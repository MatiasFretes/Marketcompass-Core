import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Core;
import modelo.CoreInit;

public class US1 {
   
	private CoreInit coreInit;
	private Core core;
	private String rutaJarCriterio = "src/test/resources/Criterios.jar";
	private List<String> productoInexistente = Arrays.asList("P3");
	private List<String> productoExistente = Arrays.asList("P1");
	private List<String> productoRepetido = Arrays.asList("P2");
	
	@BeforeEach 
	public void setup() {
		CoreInit.RUTA_JAR_CRITERIO = rutaJarCriterio;
		coreInit = new CoreInit();
		core = coreInit.inicializar();
		core.setCriterio("Distancia");
	}
	
	@Test
	public void CA1_ProductoInexistente() {
		String recomendacion = core.recomendar(productoInexistente);
		assertEquals("", recomendacion);
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
}
