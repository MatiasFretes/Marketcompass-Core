package modelo;

import java.util.Set;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorCriterio;
import extensible.SeleccionadorPorCriterio;

public class CoreInit {

	private static String RUTA_JAR_CRITERIO = ConfiguracionRutas.getRutaExtensionJAR();
       
	public Core inicializar() {
		BuscadorCriterio buscadorCriterios = new BuscadorCriterio();
		Set<SeleccionadorPorCriterio> criterios;

		try {
		    criterios = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);
		    SeleccionadorPorCriterio primerCriterio = criterios.stream().findFirst().get();
		    return new Core(primerCriterio);
		} catch (Exception e) {
			return new Core(null);
		}


	}

}