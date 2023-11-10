package modelo;

import java.util.Set;
import extensible.BuscadorCriterio;
import extensible.SeleccionadorPorCriterio;

public class CoreInit {

	private static String RUTA_JAR_CRITERIO = "C:\\marketcompass\\Criterios.jar";
       
	public Core inicializar() {
		BuscadorCriterio buscadorCriterios = new BuscadorCriterio();
		Set<SeleccionadorPorCriterio> criterios;

		try {
		    criterios = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);
		    return new Core(criterios);
		} catch (Exception e) {
			return new Core(null);
		}


	}

}