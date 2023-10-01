package modelo;

import java.util.List;

import configuracion.ConfiguracionRutas;
import extensible.BuscadorFiltradorPorCriterios;

public class Core {
	
	public Recomendacion recomendar(List<String> productos) throws Exception {
		String rutaCriterioJAR = ConfiguracionRutas.getRutaExtensionJAR();
		BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
		buscadorCriterios.buscar(rutaCriterioJAR);	
		Recomendador recomendador = new Recomendador();
		Mercado mercadoRecomendado = recomendador.recomendar(productos);
		return new Recomendacion(mercadoRecomendado);
	}

}