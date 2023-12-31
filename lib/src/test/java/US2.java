import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import extensible.BuscadorCriterio;
import extensible.SeleccionadorPorCriterio;

public class US2 {
	
	private BuscadorCriterio buscadorCriterios;
	
	private String directorioDePruebas = "src/test/resources/";
	
	@BeforeEach
    public void setUp() {
    	buscadorCriterios = new BuscadorCriterio(Arrays.asList(""));
    }

    @Test
    public void CA1_UbicacionInexistente() throws Exception {
		assertThrows(FileNotFoundException.class, () -> {
	        buscadorCriterios.buscar("ubicacionInexistente");
        });
    }
    
    @Test
    public void CA2_UbicacionInvalida() throws Exception{
    	assertThrows(IllegalArgumentException.class, () -> {
    		buscadorCriterios.buscar(directorioDePruebas + "archivo.txt");
        });
    }
       
    @Test
    public void CA3_CarpetaVacia() throws Exception{
    	assertTrue(buscadorCriterios.buscar(directorioDePruebas + "CarpetaVacia").isEmpty());
    }
    
    @Test
    public void CA4_NoEsSeleccionadorPorCriterio() throws Exception{
    	assertTrue(buscadorCriterios.buscar(directorioDePruebas + "NoEsSeleccionador").isEmpty());
    }
    
    @Test
    public void CA5_UbicacionUnicaImplementacion() throws Exception {
    	Set<SeleccionadorPorCriterio> seleccionadores = buscadorCriterios.buscar(directorioDePruebas + "SeleccionadorSimple");
    	assertTrue(seleccionadores.size() == 1);
    	assertTrue(seleccionadores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("Disponibilidad")));
    }
    
    @Test
    public void CA6_UbicacionMultiplesImplementaciones() throws Exception{
		Set<SeleccionadorPorCriterio> seleccionadores = buscadorCriterios.buscar(directorioDePruebas + "SeleccionadorMultiple");
		assertTrue(seleccionadores.size() == 2);
		assertTrue(seleccionadores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("Disponibilidad")));
		assertTrue(seleccionadores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("Precio")));
    }
}
