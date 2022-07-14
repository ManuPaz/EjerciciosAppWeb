package com.example.demorest.utils;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JerarquiaStopWatch {
    private Map<String, StopWatch> stopWatchMap;
    private Map<String, List<String>> stopWatchHijos;

    public JerarquiaStopWatch() {
        this.stopWatchHijos = new HashMap<>();
        this.stopWatchMap = new HashMap<>();
    }

    public Map<String, StopWatch> getStopWatchMap() {
        return stopWatchMap;
    }

    private synchronized String addStopWatch() {
        final StopWatch stopWatch = new StopWatch(String.valueOf(this.stopWatchMap.size()));
        this.stopWatchMap.put(stopWatch.getId(), stopWatch);
        return stopWatch.getId();
    }

    public void startStopWatch(String id) {
        this.stopWatchMap.get(id).start();
    }

    public void stopStopWatch(String id) {
        this.stopWatchMap.get(id).stop();
    }

    public String addPadre() {
        final String padreId = this.addStopWatch();
        this.stopWatchHijos.put(padreId, new ArrayList<String>());
        return padreId;
    }

    public String addHijo(String padreId) {
        final String hijoId = this.addStopWatch();
        if (this.stopWatchHijos.containsKey(padreId))
            this.stopWatchHijos.get(padreId).add(hijoId);
        return hijoId;
    }

    @Override
    public String toString() {
        String cadenaResultado = "";
        for (String idPadre : this.stopWatchHijos.keySet()) {
            cadenaResultado += "Tiempo total StopWatch con id" + idPadre + ": " + this.stopWatchMap.get(idPadre).getTotalTimeSeconds() + "\n";
            for (String idHijo : this.stopWatchHijos.get(idPadre)) {
                cadenaResultado += "-Tiempo total StopWatch hijo con id " + idHijo + ": " + this.stopWatchMap.get(idHijo).getTotalTimeSeconds() + "\n";
            }
            cadenaResultado += "-----------------";
        }
        return cadenaResultado;
    }
}
