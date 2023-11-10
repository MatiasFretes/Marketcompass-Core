package modelo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import extensible.SeleccionadorPorCriterio;

public class CriterioParser {
	
	public Set<SeleccionadorPorCriterio> criterios;
	
	public CriterioParser(Set<SeleccionadorPorCriterio> criterios){
		this.criterios = criterios;
	}
	
	public List<String> obtenerNombresCriterios(){
		return this.criterios.stream().map(c -> c.getClass().getName()).collect(Collectors.toList());
	}
	
	public SeleccionadorPorCriterio obtenerSeleccionadorCriterioPorNombre(String criterio) {
		if(criterio == null || criterio.isEmpty())
			throw new IllegalArgumentException("No se selecciono un criterio");
		
		return this.criterios.stream()
		        .filter(c -> c.getClass().getName().equals(criterio))
		        .findFirst()
		        .orElseThrow(() -> new NoSuchElementException("No se encontro ningun criterio con el nombre: " + criterio));
	}

}
