package com.marketcompass.modelo;

import extensible.BuscadorCriterios;
import extensible.FiltradorPorCriterio;
import org.apache.commons.math3.util.Pair;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Buscador {

    public Buscador() {
    }

    Pair<String, List<String>> buscar(List<String> productos){
        Map<String, List<String>> mercados = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\MultiMarket-PP2-Core\\lib\\mercados\\mercados.json";
        BuscadorCriterios buscadorCriterios = new BuscadorCriterios();
        try {
            mercados = mapper.readValue(new File(ruta), new TypeReference<>() {});
            Set<FiltradorPorCriterio> f = buscadorCriterios.buscar("C:\\Users\\Usuario\\Downloads\\lib.jar");
            FiltradorPorCriterio ff = f.stream().findFirst().get();
            mercados = obtenerMercadosPorProductos(mercados, productos);
            return ff.filtrar(mercados);

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    private Map<String, List<String>> obtenerMercadosPorProductos(Map<String, List<String>> mercados, List<String> productos){
        return mercados.entrySet().stream().filter(mercado -> mercado.getValue().containsAll(productos)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public static void main(String[] args) throws Exception {

        Buscador buscador = new Buscador();
        List<String> productos = List.of("Manzanas", "Arroz", "Camisetas");
        Pair<String, List<String>> x = buscador.buscar(productos);


        System.out.print("");
    }
   
}
