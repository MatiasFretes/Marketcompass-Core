package modelo;

import java.util.List;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorFiltradorPorCriterios;

public class Core {
	
	public Recomendacion obtenerRecomendacion(List<String> productos) throws Exception {
		String rutaCriterioJAR = ConfiguracionRutas.getRutaExtensionJAR();
		buscarCriterios(rutaCriterioJAR);	
		return recomendar(productos);
	}

	public Recomendacion recomendar(List<String> productos) throws Exception {
		Recomendador recomendador = new Recomendador();
		Mercado mercadoRecomendado = recomendador.recomendar(productos);
		return new Recomendacion(mercadoRecomendado);
	}

	public void buscarCriterios(String rutaCriterioJAR) throws Exception {
		BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
		buscadorCriterios.buscar(rutaCriterioJAR);
	}
}