package com.example.demorest.services;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Juegos;
import com.example.demorest.mapings.JuegosDtoToJuegosReduced;
import com.example.demorest.repositories.JuegosRepository;
import com.example.demorest.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class InsercionesGrandesService {
    private static final String THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK = "Ya existe una clave privada";
    private static final Logger LOGGER = LoggerFactory.getLogger(InsercionesGrandesService.class);
    @Autowired
    private JuegosDtoToJuegosReduced juegosDtoToJuegosReduced;
    @Autowired
    private JuegosRepository juegosRepository;
    @Value("${bd.insertMaxSize}")
    private int insertMaxSize;
    @Value("${bd.insertMaxThreads}")
    private int insertMaxThreads;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private boolean acabarThreads;
    private int numeroHilos;
    private long tiempoComienzo;
    private List<List<JuegosDTO>> sublistas;
    private ExecutorService executorService;

    private void configurarHilos(List<JuegosDTO> juegosDTOs) {
        this.tiempoComienzo = System.currentTimeMillis();
        this.numeroHilos = Math.min(juegosDTOs.size() / insertMaxSize, insertMaxThreads);
        final int numeroListas = juegosDTOs.size() / numeroHilos;
        this.sublistas = ListUtils.createSubList(juegosDTOs, numeroListas);
        this.executorService = Executors.newFixedThreadPool(numeroHilos);
    }

    public void guardarMultiplesJuegosCheckingIds(List<JuegosDTO> juegosDTOs) throws DataIntegrityViolationException {
        this.configurarHilos(juegosDTOs);
        final List<TareaInsertCheckingIds> callables = this.sublistas.stream().map(sublist ->
                new TareaInsertCheckingIds(sublist, this.entityManagerFactory)).toList();
        CompletionService<EntityManager> completionService = new ExecutorCompletionService<>(this.executorService);
        this.acabarThreads = false;
        for (Callable<EntityManager> callable : callables) {
            completionService.submit(callable);
        }
        int received = 0;
        ArrayList<EntityManager> entityManagers = new ArrayList<>();
        while (received < this.numeroHilos && !this.acabarThreads) {
            try {
                Future<EntityManager> resultFuture = completionService.take();
                entityManagers.add(resultFuture.get());
                received += 1;
            } catch (DataIntegrityViolationException | ExecutionException e) {
                this.acabarThreads = true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.acabarThreads = true;
            }
        }
        for (EntityManager entityManager : entityManagers) {
            if (!this.acabarThreads) {
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
        executorService.shutdown();
        LOGGER.info("Tiempo de insercion en BD: {} segundos", (System.currentTimeMillis() - tiempoComienzo) / 1000);
        LOGGER.info("Threads finished {}", received);
        if (this.acabarThreads)
            throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
    }

    public void guardarMultiplesJuegos(List<JuegosDTO> juegosDTOs) {
        this.configurarHilos(juegosDTOs);
        final CompletionService<Void> completionService = new ExecutorCompletionService<>(this.executorService);
        List<TareaInsert> callables = this.sublistas.stream().map(sublist -> new TareaInsert(sublist)).toList();
        for (Callable<Void> callable : callables) {
            completionService.submit(callable);
        }
        for (int received = 0; received < this.numeroHilos; received++) {
            try {
                Future<Void> resultFuture = completionService.take();
                resultFuture.get();
            } catch (DataIntegrityViolationException | ExecutionException exception) {
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
            }
        }
        LOGGER.info("Tiempo de insercion en BD: {} segundos", (System.currentTimeMillis() - tiempoComienzo) / 1000);
        LOGGER.info("Threads finished {}", this.numeroHilos);
    }

    public class TareaInsertCheckingIds implements Callable<EntityManager> {
        private List<JuegosDTO> juegosDTOList;
        private EntityManager entityManager;

        public TareaInsertCheckingIds(List<JuegosDTO> juegosDTOList, EntityManagerFactory entityManagerFactory) {
            this.juegosDTOList = juegosDTOList;
            this.entityManager = entityManagerFactory.createEntityManager();
        }

        @Override
        public EntityManager call() {
            entityManager.getTransaction().begin();
            List<Juegos> juegosArray = juegosDtoToJuegosReduced.juegodDtoListToJuegosReducedList(this.juegosDTOList);
            for (Juegos juegos : juegosArray) {
                if (entityManager.find(Juegos.class, juegos.getId()) == null && !acabarThreads) {
                    entityManager.merge(juegos);
                } else {
                    entityManager.getTransaction().rollback();
                    entityManager.close();
                    if (!acabarThreads)
                        throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
                    return null;
                }
            }
            return entityManager;
        }
    }

    public class TareaInsert implements Callable<Void> {
        private List<JuegosDTO> juegosDTOList;

        public TareaInsert(List<JuegosDTO> juegosDTOList) {
            this.juegosDTOList = juegosDTOList;
        }

        @Override
        public Void call() {
            List<Juegos> juegosArray = juegosDtoToJuegosReduced.juegodDtoListToJuegosReducedList(this.juegosDTOList);
            juegosRepository.saveAll(juegosArray);
            return null;
        }
    }
}

