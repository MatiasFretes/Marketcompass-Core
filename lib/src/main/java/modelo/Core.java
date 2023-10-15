package modelo;

import java.util.List;
import java.util.Set;

import extensible.FiltradorPorCriterio;

public class Core {
	
	public Recomendador recomendador;
	public Set<FiltradorPorCriterio> criterios;
	public FiltradorPorCriterio criterio;

	public Core() {
		
	}
	
	public Core(Set<FiltradorPorCriterio> criterios, List<Mercado> mercados) {
		this.criterios = criterios; 
		this.recomendador = new Recomendador(mercados);
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
	
	public void seleccionarCriterio(FiltradorPorCriterio criterioSeleccionado) {
		if (criterioSeleccionado == null) {
			System.out.println("No se selecciono critero de búsqueda");
		}
		this.criterio = criterioSeleccionado;
	}
}
