package modelo;

import java.util.List;

import extensible.FiltradorPorCriterio;

public class Core {
	
	public Recomendador recomendador;
	private Sugeridor sugeridor;
	
	public Core() {
		
	}
	
	public Core(FiltradorPorCriterio criterio, List<Mercado> mercados) {
		this.recomendador = new Recomendador(criterio, mercados);
		this.sugeridor = new Sugeridor();
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
	
	public List<String> obtenerSugerencias(List<String> productos){
		return sugeridor.sugerirProductos(productos);
	}
}
