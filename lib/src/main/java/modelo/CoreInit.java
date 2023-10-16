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
		MercadosJsonParser mercadosJsonParser = new MercadosJsonParser();
		BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
		RecomendadorObservable recomendadorObservable = new RecomendadorObservable();
		List<Mercado> mercados;
		Set<FiltradorPorCriterio> criterios;

		try {
		    mercados = mercadosJsonParser.obtenerMercados(RUTA_JSON_MERCADOS);
			criterios = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);		
		} catch (Exception e) {
			return new Core();
		}

		return new Core(criterios, mercados, recomendadorObservable);
	}

}