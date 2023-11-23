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
		
		if(esVacia(productos)) {
			RecomendacionVacia recomendacionVacia = new RecomendacionVacia();
			return recomendacionVacia.obtenerMensaje();
		}
			
		try {
			String mercado = criterioSeleccionado.seleccionarMercado(productos);
			
			if(mercado == null || mercado.isEmpty()) {
				RecomendacionVacia recomendacionVacia = new RecomendacionVacia();
				return recomendacionVacia.obtenerMensaje();
			}
				
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
	
	private boolean esVacia(List<String> lista) {
        return lista.isEmpty() || lista.stream().allMatch(String::isEmpty);
    }
}