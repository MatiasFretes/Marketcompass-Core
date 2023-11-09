package modelo;

import java.util.List;
import java.util.Observable;

import extensible.SeleccionadorPorCriterio;

@SuppressWarnings("deprecation")
public class Core extends Observable{
	
	private SeleccionadorPorCriterio criterio;

	public Core(SeleccionadorPorCriterio criterio) {
		this.criterio = criterio;
	}
	
	public Recomendacion recomendar(List<String> productos) {
    	if(productos == null)
            throw new IllegalArgumentException();

    	if(productos.isEmpty())
    		return new Recomendacion(null);
    	
		try {
			String mercado = criterio.seleccionarMercado(productos);
			setChanged();
	        notifyObservers(this);
			return new Recomendacion(mercado);
			
		} catch (Exception e) {
			return new Recomendacion(null);
		}
		
	}
}
	
	
