import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import extensible.FiltradorPorCriterio;
import modelo.Core;
import modelo.CoreInit;
import modelo.Recomendacion;

class US4 {
	private CoreInit coreInit;
	private Core core;
	private String rutaJsonMercados = "src/test/resources/mercados.json";
	private String rutaJarCriterio = "src/test/resources/DistanciasMultiples.jar";
	private List<String> productoExistente = Arrays.asList("P3");
	private String mercadoEsperadoCercano = "M1";
	private String mercadoEsperadoLejano = "M2";
	private FiltradorPorCriterio criterioDistanciaCercana;
	private FiltradorPorCriterio criterioDistanciaLejana;

	@BeforeEach 
	public void setup() {
		CoreInit.RUTA_JSON_MERCADOS = rutaJsonMercados;
		CoreInit.RUTA_JAR_CRITERIO = rutaJarCriterio;
		coreInit = new CoreInit();
		core = coreInit.inicializar();
		obtenerCriterios();
	}
	
	@Test
	public void CA1_CriterioNoSeleccionado() {
		Recomendacion recomendacion = core.obtenerRecomendacion(null,productoExistente);
		assertTrue(recomendacion.toString().equals("Lo sentimos, el sistema no ha encontrado ninguna recomendacion de mercado en este momento."));
	}
	
	@Test
	public void CA2_CriterioDistanciaCercana() {
		Recomendacion recomendacion = core.obtenerRecomendacion(criterioDistanciaCercana,productoExistente);
		assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperadoCercano));
	}

	@Test
	public void CA3_CriterioDistanciaLejana() {
		Recomendacion recomendacion = core.obtenerRecomendacion(criterioDistanciaLejana,productoExistente);
		assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperadoLejano));
	}
	
	public void obtenerCriterios() {
		Set<FiltradorPorCriterio> criterios = core.criterios;
		List<FiltradorPorCriterio> listaCriterios = new ArrayList<>(criterios);
		for (int i = 0; i < listaCriterios.size(); i++) {
			FiltradorPorCriterio criterio = listaCriterios.get(i);
		    if (i == 0) {
		    	criterioDistanciaCercana = criterio;
		    } else if (i == 1) {
		    	criterioDistanciaLejana = criterio;
		    }
		}
	}
}
