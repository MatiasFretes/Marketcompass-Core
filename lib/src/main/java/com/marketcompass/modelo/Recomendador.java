package com.marketcompass.modelo;

import org.apache.commons.math3.util.Pair;
import java.util.List;
import java.util.Map;

public class Recomendador {

    Buscador buscador;

    public Recomendador() {
        this.buscador = new Buscador();
    }

    Pair<String, List<String>> recomendar(List<String> productos){
        return buscador.buscar(productos);
    }
    
    public List<String> PruebaUI(List<String> productos){
    	productos.add("Se agrego desde el core");
    	return productos;
    }
}
