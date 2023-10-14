package modelo;

import java.util.List;

import extensible.FiltradorPorCriterio;
import observable.RecomendadorObservable;

public class Core {
	
	public Recomendador recomendador;

	public Core() {
		
	}
	
	public Core(FiltradorPorCriterio criterio, List<Mercado> mercados, RecomendadorObservable recomendadorObservable) {
		this.recomendador = new Recomendador(criterio, mercados, recomendadorObservable);
	}
	
	public Recomendacion obtenerRecomendacion(List<String> productos) {
    	if(productos == null)
            throw new IllegalArgumentException();

    	if(productos.isEmpty())
    		return new Recomendacion(null);
    	
		try {
			Recomendacion recomendacion = recomendador.recomendar(productos);
			return recomendacion;
		} catch (Exception e) {
			return new Recomendacion(null);
		}
	}
}
