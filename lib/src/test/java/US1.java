import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.BuscadorMercados;
import modelo.Core;
import modelo.CoreInit;
import modelo.Mercado;
import modelo.Recomendacion;

public class US1 {
   
	private CoreInit coreInit;
	private Core core;
	private String rutaJsonMercados = "src/test/resources/mercados.json";
	private String rutaJarCriterio = "src/test/resources/Distancia.jar";
	private List<String> productoInexistente = Arrays.asList("");
	private List<String> productoExistente = Arrays.asList("P1");
	private List<String> productoRepetido = Arrays.asList("P3");
	private List<String> productoNulo = null;
	private String mercadoEsperado = "M1";
	
	@BeforeEach 
	public void setup() throws Exception {
		CoreInit.RUTA_JSON_MERCADOS = rutaJsonMercados;
		CoreInit.RUTA_JAR_CRITERIO = rutaJarCriterio;
		coreInit = new CoreInit();
		core = coreInit.inicializar();		
	}
	
	@Test
	public void CA1_MercadoInexistente() throws Exception {
		Recomendacion recomendacion = core.obtenerRecomendacion(productoInexistente);
		assertTrue(recomendacion.isEmpty());
	}

	@Test
	public void CA2_ListaProductosInvalidos() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			core.obtenerRecomendacion(productoNulo);
        });
	}

	@Test
	public void CA3_MercadoRecomendado() throws Exception {
		Recomendacion recomendacion = core.obtenerRecomendacion(productoExistente);
	    assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperado));
	}
	
	@Test
	public void CA4_MultiplesMercados() throws Exception {
		BuscadorMercados buscadorMercados = new BuscadorMercados();
		List<Mercado> mercadosConProductos = buscadorMercados.buscar(productoRepetido, core.recomendador.mercados);
		assertTrue(mercadosConProductos.size() >= 2);
	    Recomendacion recomendacion = core.obtenerRecomendacion(productoRepetido);
		assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperado));
	}
}
