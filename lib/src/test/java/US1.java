import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.marketcompass.modelo.Recomendador;

public class US1 {
   
	Recomendador recomendador;
	@Before public void setup() {
		recomendador = new Recomendador(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void CA1() {
		List<String> productos = new ArrayList<String>();
		recomendador.recomendar(productos);
	}

//	@Test (expected = IllegalArgumentException.class)
	public void CA2() {
		List<String> productos = new ArrayList<String>();
		productos.add("??");
		recomendador.recomendar(productos);
		
	}
	
	@Test
	public void CA3() {
		List<String> productosEsperados = new ArrayList<String>();
		productosEsperados.add("Pan");
		productosEsperados.add("carne");
		recomendador.recomendar(productosEsperados);
		
	}
	
	@Test
	public void CA4() {
		List<String> productosEsperados = new ArrayList<String>();
		productosEsperados.add("Pan");
		productosEsperados.add("carne");
		recomendador.recomendar(productosEsperados);
	}
	
	@Test
	public void CA5() {
		List<String> productosEsperados = new ArrayList<String>();
		productosEsperados.add("Pan");
		productosEsperados.add("carne");
		recomendador.recomendar(productosEsperados);
	}
	
}
