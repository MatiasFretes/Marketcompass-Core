import static org.junit.jupiter.api.Assertions.assertThrows;
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
	private List<String> productoNulo = null;
	private String mercadoEsperado = "B";
	
	@BeforeEach 
	public void setup() {
		coreInit = new CoreInit();
		core = coreInit.inicializar();
	}
	
	@Test
	public void CA1_ProductoInexistente() {
		String recomendacion = core.recomendar(productoInexistente);
		assertTrue(recomendacion.isEmpty());
	}

	@Test
	public void CA2_ProductoNulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			core.recomendar(productoNulo);
        });
	}

	@Test
	public void CA3_ProductoEnUnSoloMercado() {
		String recomendacion = core.recomendar(productoExistente);
	    assertTrue(recomendacion.equals(mercadoEsperado));
	}
	
	@Test
	public void CA4_ProductoEnDistintosMercados() {
		String recomendacion = core.recomendar(productoRepetido);
	    assertTrue(recomendacion.equals(mercadoEsperado));
	}
}
