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
    private List<JuegosDTO> juegosDTOList;

    public void guardarMultiplesJuegosOneThread(List<JuegosDTO> juegosDTOs) {
        final long tiempoComienzo = System.currentTimeMillis();
        List<Juegos> juegosArray = juegosDtoToJuegosReduced.juegodDtoListToJuegosReducedList(juegosDTOs);
        juegosRepository.saveAll(juegosArray);
        LOGGER.info("Tiempo de insercion en BD: {} segundos", (System.currentTimeMillis() - tiempoComienzo) / 1000);
    }

    public void guardarMultiplesJuegos(List<JuegosDTO> juegosDTOs) {
        final long tiempoComienzo = System.currentTimeMillis();
        final int numeroHilos = Math.min(juegosDTOs.size() / insertMaxSize, insertMaxThreads)+1;
        final int numeroListas = (int) Math.ceil(juegosDTOs.size() / numeroHilos);
        List<List<JuegosDTO>> sublistas = ListUtils.createSubList(juegosDTOs, numeroListas);
        while (sublistas.size() > 0) {
            LOGGER.info("Sublistas restantes {}", sublistas.size());
            final ExecutorService executorService = Executors.newFixedThreadPool(sublistas.size());
            final CompletionService<List> completionService = new ExecutorCompletionService<>(executorService);
            List<TareaInsert> callables = sublistas.stream().map(sublist -> new TareaInsert(sublist, this.entityManagerFactory)).toList();
            for (Callable<List> callable : callables) {
                completionService.submit(callable);
            }
            final int tam = sublistas.size();
            for (int received = 0; received < tam; received++) {
                try {
                    Future<List> resultFuture = completionService.take();
                    List<JuegosDTO> lista = resultFuture.get();
                    sublistas.remove(lista);
                } catch (Exception exception) {
                    LOGGER.error(exception.getMessage());
                }
            }
            executorService.shutdown();
            if (sublistas.size() == tam) {
                throw new DataIntegrityViolationException(THROWING_EXCEPTION_FOR_DEMOING_ROLLBACK);
            }
        }
        LOGGER.info("Tiempo de insercion en BD: {} segundos", (System.currentTimeMillis() - tiempoComienzo) / 1000);
    }

    public class TareaInsert implements Callable<List> {
        private List<JuegosDTO> juegosDTOList;
        private EntityManager entityManager;

        public TareaInsert(List<JuegosDTO> juegosDTOList, EntityManagerFactory entityManagerFactory) {
            this.juegosDTOList = juegosDTOList;
            this.entityManager = entityManagerFactory.createEntityManager();
        }

        @Override
        public List call() {
            entityManager.getTransaction().begin();
            List<Juegos> juegosArray = juegosDtoToJuegosReduced.juegodDtoListToJuegosReducedList(this.juegosDTOList);
            for (Juegos juegos : juegosArray) {
                entityManager.merge(juegos);
            }
            try {
                entityManager.getTransaction().commit();
            } catch (Exception exception) {
                entityManager.close();
                throw exception;
            }
            entityManager.close();
            return this.juegosDTOList;
        }
    }
}

