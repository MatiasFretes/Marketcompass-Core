import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import extensible.BuscadorFiltradorPorCriterios;
import extensible.FiltradorPorCriterio;

public class US2 {
	
	private BuscadorFiltradorPorCriterios buscadorCriterios;
	private String ubicacionInexistente = "";
	private String ubicacionExistenteSinCriterio = "src/test/resources/SoloMain.jar";
	private String ubicacionInvalida = "src/test/resources/archivo.txt";
	private String ubicacionUnicaImplementacion = "src/test/resources/Distancia.jar";
	private String ubicacionMultiplesImplementaciones = "src/test/resources/MultiplesDistancias.jar"; 
	
	@BeforeEach
    public void setUp() {
    	buscadorCriterios = new BuscadorFiltradorPorCriterios();
    }

    @Test
    public void CA1_UbicacionInexistente() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
	        buscadorCriterios.buscar(ubicacionInexistente);
        });
    }
    
    @Test
    public void CA2_UbicacionInvalida() throws Exception{
    	assertThrows(IllegalArgumentException.class, () -> {
    		buscadorCriterios.buscar(ubicacionInvalida);
        });
    }
       
    @Test
    public void CA3_UbicacionExistenteSinCriterio() throws Exception{
    	assertThrows(RuntimeException.class, () -> {
    		buscadorCriterios.buscar(ubicacionExistenteSinCriterio);
        });
    }
    
    @Test
    public void CA4_UbicacionUnicaImplementacion() throws Exception {
    	Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(ubicacionUnicaImplementacion);
    	assertTrue(filtradores.size() == 1);
    	assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaCercana")));
    }
    
    @Test
    public void CA5_UbicacionMultiplesImplementaciones() throws Exception{
		Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(ubicacionMultiplesImplementaciones);
		assertTrue(filtradores.size() == 2);
		assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaCercana")));
		assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaLejana")));
    }
}
