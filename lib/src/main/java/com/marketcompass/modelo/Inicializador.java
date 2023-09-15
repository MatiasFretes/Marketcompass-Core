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
        Map<String, List<String>> mercadosDelJson = mapper.readValue(new File(rutaJsonMercados), new TypeReference<Map<String, List<String>>>(){});
		MERCADOS = mercadosDelJson;
		
		BuscadorCriterios buscadorCriterios = new BuscadorCriterios();
        Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(rutaCriterioJAR);
        CRITERIO = filtradores.stream().findFirst().get();
	}

}
