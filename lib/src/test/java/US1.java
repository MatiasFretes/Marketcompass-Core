import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Core;
import modelo.Inicializador;
import modelo.Recomendacion;

public class US1 {
   
	private Core core;
	private Inicializador inicializador;
	private String rutaJsonMercados = "src/test/resources/mercados.json";
	private String rutaJarCriterio = "src/test/resources/Distancia.jar";
	private List<String> productoInexistente = Arrays.asList("");
	private List<String> productoExistente = Arrays.asList("P1");
	private List<String> productoRepetido = Arrays.asList("P3");
	private List<String> productoNulo = null;
	private String mercadoEsperado = "M1";
	
	@BeforeEach 
	public void setup() throws Exception {
		inicializador = new Inicializador();
		inicializador.iniciarMercados(rutaJsonMercados);
		core = new Core();	
	}
	
	@Test
	public void CA1_MercadoInexistente() throws Exception {	
		core.buscarCriterios(rutaJarCriterio);
		Recomendacion recomendacion = core.recomendar(productoInexistente);
		assertTrue(recomendacion.isEmpty());
	}

	@Test
	public void CA2_ListaProductosInvalidos() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			core.recomendar(productoNulo);
        });
	}

	@Test
	public void CA3_MercadoRecomendado() throws Exception {
		core.buscarCriterios(rutaJarCriterio);
	    Recomendacion recomendacion = core.recomendar(productoExistente);    
	    assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperado));
	}
	
	@Test
	public void CA4_MultiplesMercados() throws Exception {
		core.buscarCriterios(rutaJarCriterio);
		Recomendacion recomendacion = core.recomendar(productoRepetido);
		assertTrue(recomendacion.getMercado().getNombre().equals(mercadoEsperado));
	}
	
/* EN DUDA
	@Test
	public void CA5_MultiplesCriterios() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar(ubicacionJsonConDosMercados, ubicacionMultiplesImplementaciones);
		assertTrue(Inicializador.CRITERIO.getClass().getSimpleName().equals("DistanciaCercana"));
		Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(Arrays.asList("P2"));
		validarMercadoRecomendado(mercadoRecomendado, "M1", Arrays.asList("P2"));
	}
		
	@Test(expected = Exception.class)
	public void CA6() throws Exception {
	   inicializador = new Inicializador();   
	   inicializador.inicializar(ubicacionSinMercados, ubicacionUnicaImplementacion);
	}
	*/
}
