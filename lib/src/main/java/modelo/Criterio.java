package modelo;

import extensible.FiltradorPorCriterio;

public class Criterio {

	public static FiltradorPorCriterio CRITERIO;

	public static void guardarCriterio(FiltradorPorCriterio filtradorPorCriterio) {
		CRITERIO =  filtradorPorCriterio;
	}
}
