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
		FiltradorPorCriterio criterio = null;
		RecomendadorObservable recomendadorObservable = new RecomendadorObservable();

		try {
		    mercados = MercadosJsonParser.obtenerMercados(RUTA_JSON_MERCADOS);
		    BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
			Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);
			criterio = filtradores.stream().findFirst().get();		
		} catch (Exception e) {
			return new Core();
		}
		
		return new Core(criterio, mercados, recomendadorObservable);
	}
}