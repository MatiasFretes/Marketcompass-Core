package com.marketcompass.modelo;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import extensible.BuscadorCriterios;
import extensible.FiltradorPorCriterio;

public class Inicializador {

	public static Map<String, List<String>> MERCADOS;
	public static FiltradorPorCriterio CRITERIO;
	
	public void inicializar(String rutaJsonMercados, String rutaCriterioJAR) throws Exception {
		ObjectMapper mapper = new ObjectMapper();   
	    BuscadorCriterios buscadorCriterios = new BuscadorCriterios();   
	    MERCADOS = mapper.readValue(new File(rutaJsonMercados), new TypeReference<>() {});   
	    try {
	      Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(rutaCriterioJAR);      
	      CRITERIO = filtradores.stream().findFirst().get();   
	      }catch (Exception e){
	      CRITERIO = null;   
	    }
	}

}
