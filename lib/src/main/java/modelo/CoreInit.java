package modelo;

import java.util.List;
import java.util.Set;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorFiltradorPorCriterios;
import extensible.FiltradorPorCriterio;

public class CoreInit {

	public static String RUTA_JSON_MERCADOS = ConfiguracionRutas.getRutaJsonMercados();
	public static String RUTA_JAR_CRITERIO = ConfiguracionRutas.getRutaExtensionJAR();
	
	public Core inicializar() {
		List<Mercado> mercados;
		Set<FiltradorPorCriterio> criterios;
		//FiltradorPorCriterio criterio = null;

		try {
		    mercados = MercadosJsonParser.obtenerMercados(RUTA_JSON_MERCADOS);
		    BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
			criterios = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);
			//criterio = filtradores.stream().findFirst().get();		
		} catch (Exception e) {
			return new Core();
		}
		
		return new Core(criterios, mercados);
	}

}