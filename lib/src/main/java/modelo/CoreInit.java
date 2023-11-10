package modelo;

import java.util.Set;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorCriterio;
import extensible.SeleccionadorPorCriterio;

public class CoreInit {

	public static String RUTA_JAR_CRITERIO = ConfiguracionRutas.getRutaExtensionJAR();
       
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