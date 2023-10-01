import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
//	private String ubicacionJsonConUnMercado = "src/test/resources/escenarioMercados.json";
//	private String ubicacionJsonConDosMercados = "src/test/resources/escenarioCon2Mercados.json";
//	private String ubicacionUnicaImplementacion = "src/test/resources/Distancia.jar";
//	private String ubicacionMultiplesImplementaciones = "src/test/resources/MultiplesDistancias.jar"; 
//	private String ubicacionSinCriterios = "src/test/resources/SoloMain.jar";
//	private String ubicacionSinMercados = "src/test/resources/archivo.txt";
	
	private List<String> productosInexistentes = Arrays.asList("");
	
	@BeforeEach 
	public void setup() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar();
		core = new Core();	
	}
	
	@Test
	public void CA1_MercadoInexistente() throws Exception {
		Recomendacion recomendacion = core.recomendar(productosInexistentes);
		assertNull(recomendacion.getMercado());
	}

	@Test
	public void CA2_ListaProductosInvalidos() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			core.recomendar(null);
        });
	}

	/*
	@Test
	public void CA3() throws Exception {
		Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(Arrays.asList("P1", "P2"));
		validarMercadoRecomendado(mercadoRecomendado, "M1", Arrays.asList("P1", "P2"));
	}
	
	@Test
	public void CA4() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar(ubicacionJsonConDosMercados, ubicacionUnicaImplementacion);
		Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(Arrays.asList("P2"));
		validarMercadoRecomendado(mercadoRecomendado,"M1", Arrays.asList("P2"));
	}
	
	@Test
	public void CA5() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar(ubicacionJsonConDosMercados, ubicacionMultiplesImplementaciones);
		assertTrue(Inicializador.CRITERIO.getClass().getSimpleName().equals("DistanciaCercana"));
		Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(Arrays.asList("P2"));
		validarMercadoRecomendado(mercadoRecomendado, "M1", Arrays.asList("P2"));
	}
	
	@Test
	public void CA6() throws Exception {
	   inicializador = new Inicializador();   
	   inicializador.inicializar(ubicacionJsonConUnMercado, ubicacionSinCriterios);   
	   Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(List.of("P2"));  
		validarMercadoRecomendado(mercadoRecomendado, "M1", Arrays.asList("P2"));
	}

	@Test(expected = Exception.class)
	public void CA7() throws Exception {
	   inicializador = new Inicializador();   
	   inicializador.inicializar(ubicacionSinMercados, ubicacionUnicaImplementacion);
	}

	private void validarMercadoRecomendado(Pair<String, List<String>> mercadoRecomendado, String mercadoEsperado, List<String> productosEsperados) {
		assertNotNull(mercadoRecomendado);
		assertTrue(mercadoRecomendado.getKey().equals(mercadoEsperado));
		assertTrue(mercadoRecomendado.getValue().size() == productosEsperados.size());
		assertTrue(mercadoRecomendado.getValue().equals(productosEsperados));
	}
	*/
}
