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
		try {
			String mercado = criterioSeleccionado.seleccionarMercado(productos);
			setChanged();
	        notifyObservers(productos);
			return mercado;
		} catch (Exception e) {
			return "";
		}
	}
	
	public List<String> obtenerNombresCriterios(){
		return criterioParser.obtenerNombresCriterios();
	}
	
	public void setCriterio(String nombreCriterio) {
		this.criterioSeleccionado = criterioParser.obtenerSeleccionadorCriterioPorNombre(nombreCriterio);
	}
}