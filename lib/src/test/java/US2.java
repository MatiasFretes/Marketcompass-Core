import static org.junit.Assert.assertTrue;

import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import extensible.BuscadorCriterios;
import extensible.FiltradorPorCriterio;

public class US2 {
	
	private BuscadorCriterios buscadorCriterios;
	private String ubicacionExistenteSinCriterio = "src/test/resources/SoloMain.jar";
	private String ubicacionInvalida = "src/test/resources/archivo.txt";
	private String ubicacionUnicaImplementacion = "src/test/resources/Distancia.jar";
	private String ubicacionMultiplesImplementaciones = "src/test/resources/MultiplesDistancias.jar"; 
	
    @Before
    public void setUp() {
    	buscadorCriterios = new BuscadorCriterios();
    }

    @Test(expected = IllegalArgumentException.class)
    public void CA1() throws Exception {
        buscadorCriterios.buscar("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CA2() throws Exception{
    	buscadorCriterios.buscar(ubicacionInvalida);
    }
       
    @Test(expected = RuntimeException.class)
    public void CA3() throws Exception{
    	buscadorCriterios.buscar(ubicacionExistenteSinCriterio);
    }
    
    @Test
    public void CA4() throws Exception {
    	Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(ubicacionUnicaImplementacion);
    	assertTrue(!filtradores.isEmpty());
    	assertTrue(filtradores .size() == 1);
    	assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaCercana")));
    }
    
    @Test
    public void CA5() throws Exception{
		Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(ubicacionMultiplesImplementaciones);
		assertTrue(!filtradores.isEmpty());
		assertTrue(filtradores .size() == 2);
		assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaCercana")));
		assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaLejana")));
    }
}
