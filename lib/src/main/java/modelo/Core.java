package modelo;

import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.stream.Collectors;
import extensible.SeleccionadorPorCriterio;

@SuppressWarnings("deprecation")
public class Core extends Observable{
	
	public Set<SeleccionadorPorCriterio> criterios;
	private SeleccionadorPorCriterio criterioSeleccionado;

	public Core(Set<SeleccionadorPorCriterio> criterios) {
		this.criterios = criterios;
		this.criterioSeleccionado = criterios.stream().findFirst().get();
	}
	
	public Recomendacion recomendar(List<String> productos) {
    	if(productos == null)
            throw new IllegalArgumentException();

    	if(productos.isEmpty())
    		return new Recomendacion(null);
    	
		try {
			String mercado = criterioSeleccionado.seleccionarMercado(productos);
			setChanged();
	        notifyObservers(this);
			return new Recomendacion(mercado);
		} catch (Exception e) {
			return new Recomendacion(null);
		}
		
	}
	
	public List<String> obtenerNombresCriterios(){
		return this.criterios.stream().map(c -> c.getClass().getName()).collect(Collectors.toList());
	}
	
	public void setCriterio(String criterio) {
		this.criterioSeleccionado = this.criterios.stream().filter(c -> c.getClass().getName().equals(criterio)).findFirst().orElse(null);
	}
}