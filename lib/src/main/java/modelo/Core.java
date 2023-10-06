package modelo;

import java.util.List;
import java.util.Set;
import configuracion.ConfiguracionRutas;
import extensible.BuscadorFiltradorPorCriterios;
import extensible.FiltradorPorCriterio;

public class Core {

	public static String RUTA_JSON_MERCADOS = ConfiguracionRutas.getRutaJsonMercados();
	public static String RUTA_JAR_CRITERIO = ConfiguracionRutas.getRutaExtensionJAR();
	
	public Core (List<String> productos) throws Exception {
		PeticionUsuario.guardarProductos(productos);
				
		//Iniciar mercados
		List<Mercado> mercados = MercadosJsonParser.obtenerMercados(RUTA_JSON_MERCADOS);
		ProveedorMercados.guardarMercados(mercados);
		
		//Iniciar criterio
		BuscadorFiltradorPorCriterios buscadorCriterios = new BuscadorFiltradorPorCriterios();
		Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(RUTA_JAR_CRITERIO);
		Criterio.guardarCriterio(filtradores.stream().findFirst().get());		
	}
	
	public Recomendacion recomendar() throws Exception {
		Recomendador recomendador = new Recomendador();
		Mercado mercadoRecomendado = recomendador.recomendar();
		return new Recomendacion(mercadoRecomendado);
	}

}