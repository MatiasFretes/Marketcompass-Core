package modelo;

import java.util.List;
import java.util.Set;

import extensible.FiltradorPorCriterio;
import observable.RecomendadorObservable;

public class Core {
	
	public Recomendador recomendador;
	public Set<FiltradorPorCriterio> criterios;
	public FiltradorPorCriterio criterio;

	public Core() {
		
	}
	
	public Core(Set<FiltradorPorCriterio> criterios, List<Mercado> mercados, RecomendadorObservable recomendadorObservable) {
		this.criterios = criterios; 
		this.recomendador = new Recomendador(mercados, recomendadorObservable);
	}
	
	public Recomendacion obtenerRecomendacion(FiltradorPorCriterio criterio,List<String> productos) {
    	if(productos == null)
            throw new IllegalArgumentException();

    	if(productos.isEmpty())
    		return new Recomendacion(null);
    	
		try {
			Recomendacion recomendacion = recomendador.recomendar(criterio, productos);
			return recomendacion;
		} catch (Exception e) {
			return new Recomendacion(null);
		}
	}
}
