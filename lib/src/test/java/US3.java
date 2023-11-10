import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Core;
import modelo.CoreInit;

class US3 {
    private CoreInit coreInit;
    private Core core;
    private String rutaJarCriterio = "src/test/resources/Criterios.jar";

    @BeforeEach
    public void setup() {
    	CoreInit.RUTA_JAR_CRITERIO = rutaJarCriterio;
        coreInit = new CoreInit();
        core = coreInit.inicializar();
    }

    @Test
    public void CA1_CriterioInvalido(){
    	assertThrows(IllegalArgumentException.class, () -> {
    		core.setCriterio("");
        });
    }
    
    @Test
    public void CA2_CriterioInexistente(){
    	assertThrows(NoSuchElementException.class, () -> {
    		core.setCriterio("CriterioInexistente");
        });
    }

	@Test
	public void CA3_CriterioSeleccionado(){	
		core.setCriterio("Distancia");
		assertEquals("Distancia", core.criterioSeleccionado.getClass().getName());
	} 
}