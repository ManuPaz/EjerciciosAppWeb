package com.example.demorest.services;

import com.example.demorest.dtos.JuegosDTO;
import com.example.demorest.entities.Juegos;
import com.example.demorest.mapings.JuegosDtoToJuegosReduced;
import com.example.demorest.repositories.JuegosRepository;
import com.example.demorest.utils.JerarquiaStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

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
    @Value("${bd.batchSize}")
    private int batchSize;
    private int posicionLista;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private List<JuegosDTO> juegosDTOList;
    private JerarquiaStopWatch jerarquiaStopWatch;
    private String stopWatchPadreId;

    public void guardarMultiplesJuegosOneThread(List<JuegosDTO> juegosDTOs) {
        final long tiempoComienzo = System.currentTimeMillis();
        List<Juegos> juegosArray = juegosDtoToJuegosReduced.juegodDtoListToJuegosReducedList(juegosDTOs);
        juegosRepository.saveAll(juegosArray);
        LOGGER.info("Tiempo de insercion en BD: {} segundos", (System.currentTimeMillis() - tiempoComienzo) / 1000);
    }

    public void guardarMultiplesJuegos(List<JuegosDTO> juegosDTOs) {
        this.jerarquiaStopWatch = new JerarquiaStopWatch();
        this.stopWatchPadreId = this.jerarquiaStopWatch.addPadre();
        this.jerarquiaStopWatch.startStopWatch(stopWatchPadreId);
        this.juegosDTOList = juegosDTOs;
        final int numeroHilos = Math.max(1, Math.min(juegosDTOs.size() / insertMaxSize, insertMaxThreads));
        posicionLista = 0;
        LOGGER.info("Numero de hilos: {}", numeroHilos);
        final ExecutorService executorService = Executors.newFixedThreadPool(numeroHilos);
        final CompletionService<Void> completionService = new ExecutorCompletionService<>(executorService);
        List<TareaInsert> callables = IntStream.range(0, numeroHilos).mapToObj(sublist -> new TareaInsert(this.entityManagerFactory)).toList();
        for (Callable<Void> callable : callables) {
            completionService.submit(callable);
        }
        for (int received = 0; received < numeroHilos; received++) {
            try {
                Future<Void> resultFuture = completionService.take();
                resultFuture.get();
            } catch (Exception exception) {
                LOGGER.error(exception.getMessage());
            }
        }
        executorService.shutdown();
        this.jerarquiaStopWatch.stopStopWatch(stopWatchPadreId);
        System.out.println(this.jerarquiaStopWatch);
    }

    public class TareaInsert implements Callable<Void> {
        private EntityManager entityManager;

        public TareaInsert(EntityManagerFactory entityManagerFactory) {
            this.entityManager = entityManagerFactory.createEntityManager();
        }

        private List<JuegosDTO> getSiguiente() {
            List<JuegosDTO> sublist;
            synchronized (juegosDTOList) {
                if (posicionLista < juegosDTOList.size()) {
                    sublist = juegosDTOList.subList(posicionLista, Math.min(posicionLista + batchSize, juegosDTOList.size()));
                    posicionLista += batchSize;
                    return sublist;
                } else {
                    return null;
                }
            }
        }

        @Override
        public Void call() {

            String stopWatchHijoId=jerarquiaStopWatch.addHijo(stopWatchPadreId);
            jerarquiaStopWatch.startStopWatch(stopWatchHijoId);
            while (true) {
                List<JuegosDTO> sublist = getSiguiente();
                if (sublist == null)
                    break;
                List<Juegos> juegosArray = juegosDtoToJuegosReduced.juegodDtoListToJuegosReducedList(sublist);
                try {
                    entityManager.getTransaction().begin();
                    for (Juegos juegos : juegosArray) {
                        entityManager.merge(juegos);
                    }
                    entityManager.getTransaction().commit();
                } catch (Exception exception) {
                    LOGGER.error(exception.getMessage());
                    break;
                }
            }
            entityManager.close();
            jerarquiaStopWatch.stopStopWatch(stopWatchHijoId);
            return null;
        }
    }
}

