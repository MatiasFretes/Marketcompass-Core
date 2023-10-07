package modelo;

import java.util.List;

import extensible.FiltradorPorCriterio;

public class Core {
	
	public Recomendador recomendador;

	public Core(FiltradorPorCriterio criterio, List<Mercado> mercados) {
		this.recomendador = new Recomendador(criterio, mercados);
	}
	
	public Recomendacion obtenerRecomendacion(List<String> productos) throws Exception {
		return recomendador.recomendar(productos);
	}
}
