package modelo;

import java.util.List;
import java.util.Set;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorFiltradorPorCriterios;
import extensible.FiltradorPorCriterio;

public class CoreInit {

	public static String RUTA_JSON_MERCADOS = ConfiguracionRutas.getRutaJsonMercados();
	public static String RUTA_JAR_CRITERIO = ConfiguracionRutas.getRutaExtensionJAR();
	
	public Core inicializar() throws Exception {	
		//Iniciar mercados
		List<Mercado> mercados = MercadosJsonParser.obtenerMercados(RUTA_JSON_MERCADOS);
		
		//Iniciar criterio
		BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
		Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);
		FiltradorPorCriterio criterio = filtradores.stream().findFirst().get();	
		
		return new Core(criterio, mercados);
	}
}