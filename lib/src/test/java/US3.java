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
	private String directorioDePrueba = "src/test/resources/SeleccionadorSimple";

    @BeforeEach
    public void setup() {
    	coreInit = new CoreInit();
		coreInit.setDirectorio(directorioDePrueba);
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
		core.setCriterio("Disponibilidad");
		assertEquals("Disponibilidad", core.criterioSeleccionado.getClass().getName());
	} 
}