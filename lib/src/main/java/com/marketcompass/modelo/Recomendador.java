package com.marketcompass.modelo;

import org.apache.commons.math3.util.Pair;

import java.util.List;
import java.util.Map;

public class Recomendador {

    Buscador buscador;

    public Recomendador(Buscador buscador) {
        this.buscador = buscador;
    }

    Pair<String, List<String>> recomendar(List<String> productos){
        return buscador.buscar(productos);
    }
}
