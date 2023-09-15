package com.marketcompass.modelo;

import org.apache.commons.math3.util.Pair;
import java.util.List;

public class Recomendador {

    Buscador buscador;

    public Recomendador() {
        this.buscador = new Buscador();
    }

    public Pair<String, List<String>> recomendar(List<String> productos) throws Exception{
    	if(productos == null || productos.isEmpty())
            throw new IllegalArgumentException();

    	return buscador.buscar(productos);
    }
    
    //Prueba para proyecto UI
    public List<String> PruebaUI(List<String> productos){
    	productos.add("Se agrego desde el core");
    	return productos;
    }
}
