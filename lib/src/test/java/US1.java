import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.junit.Before;
import org.junit.Test;

import com.marketcompass.modelo.Inicializador;
import com.marketcompass.modelo.Recomendador;

public class US1 {
   
	private Recomendador recomendador;
	private Inicializador inicializador;
	private String ubicacionJsonConUnMercado = "src/test/resources/escenarioMercados.json";
	private String ubicacionJsonConDosMercados = "src/test/resources/escenarioCon2Mercados.json";
	private String ubicacionUnicaImplementacion = "src/test/resources/Distancia.jar";
	private String ubicacionMultiplesImplementaciones = "src/test/resources/MultiplesDistancias.jar"; 
	
	@Before public void setup() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar(ubicacionJsonConUnMercado, ubicacionUnicaImplementacion);
		recomendador = new Recomendador();	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void CA1() throws Exception {
		List<String> productos = new ArrayList<String>();
		recomendador.recomendar(productos);
	}

	@Test
	public void CA2() throws Exception {
		List<String> productos = Arrays.asList("??");
		assertNull(recomendador.recomendar(productos));
	}
	
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

	private void validarMercadoRecomendado(Pair<String, List<String>> mercadoRecomendado, String mercadoEsperado, List<String> productosEsperados) {
		assertNotNull(mercadoRecomendado);
		assertTrue(mercadoRecomendado.getKey().equals(mercadoEsperado));
		assertTrue(mercadoRecomendado.getValue().size() == productosEsperados.size());
		assertTrue(mercadoRecomendado.getValue().equals(productosEsperados));
	}
}
