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
   
	Recomendador recomendador;
	Inicializador inicializador;
	String rutaJsonConUnMercado = "src/test/resources/escenarioMercados.json";
	String rutaJsonConDosMercado = "src/test/resources/escenarioCon2Mercados.json";
	String rutaAlCriterioJAR = "src/test/resources/FiltroDevolverPrimero.jar";
	
	
	@Before public void setup() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar(rutaJsonConUnMercado, rutaAlCriterioJAR);
		recomendador = new Recomendador();	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void CA1() throws Exception {
		List<String> productos = new ArrayList<String>();
		recomendador.recomendar(productos);
	}

	@Test
	public void CA2() throws Exception {
		List<String> productos = new ArrayList<String>();
		productos.add("??");
		assertNull(recomendador.recomendar(productos));
	}
	
	@Test
	public void CA3() throws Exception {
		List<String> productosEsperados = new ArrayList<String>();
		productosEsperados.add("P1");
		productosEsperados.add("P2");
		Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(productosEsperados);
		assertNotNull(mercadoRecomendado);
		assertTrue(mercadoRecomendado.getKey().equals("M1"));
		assertTrue(mercadoRecomendado.getValue().size() == 2);
		assertTrue(mercadoRecomendado.getValue().equals(productosEsperados));
	}
	
	@Test
	public void CA4() throws Exception {
		inicializador = new Inicializador();
		inicializador.inicializar(rutaJsonConDosMercado, rutaAlCriterioJAR);
		Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(Arrays.asList("P2"));
		assertNotNull(mercadoRecomendado);
		assertTrue(mercadoRecomendado.getKey().equals("M1"));
		assertTrue(mercadoRecomendado.getValue().size() == 1);
		assertTrue(mercadoRecomendado.getValue().equals(Arrays.asList("P2")));
	}
}
