package com.marketcompass.modelo;

import extensible.FiltradorPorCriterio;
import org.apache.commons.math3.util.Pair;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Buscador {

    FiltradorPorCriterio filtradorPorCriterio;

    public Buscador(FiltradorPorCriterio filtradorPorCriterio) {
        this.filtradorPorCriterio = filtradorPorCriterio;
    }

    Pair<String, List<String>> buscar(List<String> productos){
        Map<String, List<String>> mercados = new HashMap<>();

        
        return filtradorPorCriterio.filtrar(mercados);
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> mercados = new HashMap<>();
        String ruta = "mercados/mercados.json";
        
        try {
            mercados = mapper.readValue(new File(ruta), new TypeReference<Map<String, List<String>>>(){});
            System.out.print(mercados);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   
}
