package modelo;

import java.util.List;
import java.util.Set;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorFiltradorPorCriterios;
import extensible.FiltradorPorCriterio;
import observable.RecomendadorObservable;

public class CoreInit {

	public static String RUTA_JSON_MERCADOS = ConfiguracionRutas.getRutaJsonMercados();
	public static String RUTA_JAR_CRITERIO = ConfiguracionRutas.getRutaExtensionJAR();
       
	public Core inicializar() {
		List<Mercado> mercados;
		Set<FiltradorPorCriterio> criterios;
		RecomendadorObservable recomendadorObservable = new RecomendadorObservable();

		try {
		    mercados = MercadosJsonParser.obtenerMercados(RUTA_JSON_MERCADOS);
		    BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
			criterios = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);		
		} catch (Exception e) {
			return new Core();
		}

		return new Core(criterios, mercados, recomendadorObservable);
	}

}