package modelo;

import java.util.List;
import java.util.Observable;
import java.util.Set;
import extensible.SeleccionadorPorCriterio;

@SuppressWarnings("deprecation")
public class Core extends Observable{
	
	public SeleccionadorPorCriterio criterioSeleccionado;
	public CriterioParser criterioParser;

	public Core(Set<SeleccionadorPorCriterio> criterios) {
		this.criterioSeleccionado = criterios.stream().findFirst().get();
		this.criterioParser = new CriterioParser(criterios);
	}
	
	public String recomendar(List<String> productos) {   	
		if(productos == null)
			throw new IllegalArgumentException("Lista de productos invalida");
			
		try {
			String mercado = criterioSeleccionado.seleccionarMercado(productos);
			setChanged();
	        notifyObservers(productos);
			return mercado == null || mercado.isEmpty() ? "Recomendacion inexistente" : mercado;
		} catch (Exception e) {
			return "Recomendacion inexistente" ;
		}
	}
	
	public List<String> obtenerNombresCriterios(){
		return criterioParser.obtenerNombresCriterios();
	}
	
	public void setCriterio(String nombreCriterio) {
		this.criterioSeleccionado = criterioParser.obtenerSeleccionadorCriterioPorNombre(nombreCriterio);
	}
}