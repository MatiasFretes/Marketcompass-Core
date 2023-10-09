import static org.junit.jupiter.api.Assertions.assertNotNull;
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
	private BuscadorMercados buscadorMercados;
	private String rutaJsonMercados = "src/test/resources/mercados.json";
	private String rutaJarCriterio = "src/test/resources/Distancia.jar";
	private String rutaInexistente = "NoExisteEstaRuta";
	private List<String> productoInexistente = Arrays.asList("");
	private List<String> productoExistente = Arrays.asList("P1");
	private List<String> productoRepetido = Arrays.asList("P3");
	private List<String> productoNulo = null;
	private String mercadoEsperado = "M1";
	
	@BeforeEach 
	public void setup() {
		CoreInit.RUTA_JSON_MERCADOS = rutaJsonMercados;
		CoreInit.RUTA_JAR_CRITERIO = rutaJarCriterio;
		coreInit = new CoreInit();
		core = coreInit.inicializar();
		buscadorMercados = new BuscadorMercados();
	}
	
	@Test
	public void CA1_MercadoInexistente() {
		Recomendacion recomendacion = core.obtenerRecomendacion(productoInexistente);
		assertTrue(recomendacion.isEmpty());
	}

	@Test
	public void CA2_ListaProductosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> {
			core.obtenerRecomendacion(productoNulo);
        });
	}

	@Test
	public void CA3_MercadoRecomendado() {
		Recomendacion recomendacion = core.obtenerRecomendacion(productoExistente);
	    assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperado));
	}
	
	@Test
	public void CA4_MultiplesMercados() {
		List<Mercado> mercadosConProductos = buscadorMercados.buscar(productoRepetido, core.recomendador.mercados);
		assertTrue(mercadosConProductos.size() >= 2);
	    Recomendacion recomendacion = core.obtenerRecomendacion(productoRepetido);
		assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperado));
	}
	
	@Test
	public void CA5_InicializacionCoreConRutasInexistentes() {
		CoreInit.RUTA_JSON_MERCADOS = rutaInexistente;
		CoreInit.RUTA_JAR_CRITERIO = rutaInexistente;
		CoreInit coreInitConRutasInexistentes = new CoreInit();
		Core coreConRutasInexistentes = coreInitConRutasInexistentes.inicializar();
		assertNotNull(coreConRutasInexistentes);
	}
}
