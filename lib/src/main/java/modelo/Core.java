package modelo;

import java.util.List;

import configuracion.Configuracion;
import extensible.BuscadorFiltradorPorCriterios;

public class Core {
	
	public void recomendar(List<String> productos, Recomendacion recomendacion) throws Exception {
		String rutaCriterioJAR = Configuracion.getRutaExtensionJAR();
		BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
		buscadorCriterios.buscar(rutaCriterioJAR);	
		Recomendador recomendador = new Recomendador();
		recomendador.recomendar(productos, recomendacion);
	}

}