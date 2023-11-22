import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Core;
import modelo.CoreInit;
import modelo.ProveedorMercados;

public class US1 {
   
	private CoreInit coreInit;
	private Core core;
	private String directorioDePrueba = "src/test/resources/SeleccionadorSimple";
	private List<String> productoVacio = Arrays.asList("");
	private List<String> productoInexistente = Arrays.asList("P3");
	private List<String> productoExistente = Arrays.asList("P1");
	private List<String> productoRepetido = Arrays.asList("P2");
	private List<String> multiplesProductos = Arrays.asList("P1", "P2", "P3");	
	
	@BeforeEach 
	public void setup() {
	    ProveedorMercados proveedorMercadosMock = mock(ProveedorMercados.class);
	    when(proveedorMercadosMock.obtenerMercados()).thenReturn(Arrays.asList("A", "B"));
		coreInit = new CoreInit();
		coreInit.setDirectorio(directorioDePrueba);
		coreInit.setProveedorMercados(proveedorMercadosMock);
		core = coreInit.inicializar();
	}
	
	@Test
	public void CA1_ProductoInexistente() {
		String recomendacion = core.recomendar(productoInexistente);
		assertTrue(recomendacion.isEmpty());
	}
	
	@Test
	public void CA2_ProductoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> {
			core.recomendar(null);
	    });
	}
	
	@Test
	public void CA3_ProductoEnUnSoloMercado() {
		String recomendacion = core.recomendar(productoExistente);
		assertEquals("B", recomendacion);
	}
	
	@Test
	public void CA4_ProductoEnDistintosMercados() {
		String recomendacion = core.recomendar(productoRepetido);
		assertEquals("A", recomendacion);
	}
	
	@Test
	public void CA5_ProductoVacio() {
		String recomendacion = core.recomendar(productoVacio);
		assertTrue(recomendacion.isEmpty());
	}
	
	@Test
	public void CA6_MultiplesProductos() {
		String recomendacion = core.recomendar(multiplesProductos);
		assertEquals("B", recomendacion);
	}
}
