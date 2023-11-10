import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Core;
import modelo.CoreInit;

public class US1 {
   
	private CoreInit coreInit;
	private Core core;
	private List<String> productoInexistente = Arrays.asList("");
	private List<String> productoExistente = Arrays.asList("P1");
	private List<String> productoRepetido = Arrays.asList("P2");
	
	@BeforeEach 
	public void setup() {
		coreInit = new CoreInit();
		core = coreInit.inicializar();
		core.setCriterio("Distancia");
	}
	
	@Test
	public void CA1_ProductoInexistente() {
		String recomendacion = core.recomendar(productoInexistente);
		assertTrue(recomendacion.isEmpty());
	}

	@Test
	public void CA2_ProductoEnUnSoloMercado() {
		String recomendacion = core.recomendar(productoExistente);
		assertEquals("B", recomendacion);
	}
	
	@Test
	public void CA3_ProductoEnDistintosMercados() {
		String recomendacion = core.recomendar(productoRepetido);
		assertEquals("A", recomendacion);
	}
}
