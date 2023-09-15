package com.marketcompass.modelo;

import extensible.FiltradorPorCriterio;
import org.apache.commons.math3.util.Pair;
import java.util.*;
import java.util.stream.Collectors;

public class Buscador {

    public Pair<String, List<String>> buscar(List<String> productos) throws Exception{
        Map<String, List<String>> mercados = Inicializador.MERCADOS;
        FiltradorPorCriterio filtroPorCriterio = Inicializador.CRITERIO;
        mercados = obtenerMercadosPorProductos(mercados, productos);
        return filtroPorCriterio.filtrar(mercados);

    }

    private Map<String, List<String>> obtenerMercadosPorProductos(Map<String, List<String>> mercados, List<String> productos){
        Map<String, List<String>> mercadosPorProductos = mercados.entrySet().stream().filter(mercado -> mercado.getValue().containsAll(productos)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        mercadosPorProductos.forEach((key, value) -> value.retainAll(productos));
        return mercadosPorProductos;
    }
}
