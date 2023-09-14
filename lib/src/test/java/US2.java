import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import extensible.BuscadorCriterios;
import extensible.FiltradorPorCriterio;

public class US2 {
	
	private BuscadorCriterios buscadorCriterios;
	
    @Before
    public void setUp() {
    	buscadorCriterios = new BuscadorCriterios();
    }

    @Test(expected = IllegalArgumentException.class)
    public void CA1() throws Exception {
        String ubicacionInexistente = "";
        buscadorCriterios.buscar(ubicacionInexistente);
    }
    
    @Test(expected = RuntimeException.class)
    public void CA2() throws Exception{
    	String ubicacionExistenteSinCriterio = "src/test/resources/SoloMain.jar";
    	buscadorCriterios.buscar(ubicacionExistenteSinCriterio);
    }
    
    @Test
    public void CA3() throws Exception {
    	String ubicacionExistente = "src/test/resources/Distancia.jar";
    	Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(ubicacionExistente);
    	assertTrue(!filtradores.isEmpty());
    	assertTrue(filtradores .size() == 1);
    	assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaCercana")));
    }
    
    @Test
    public void CA4() throws Exception{
		String ubicacionExistente = "src/test/resources/MultiplesDistancias.jar";
		Set<FiltradorPorCriterio> filtradores = buscadorCriterios.buscar(ubicacionExistente);
		assertTrue(!filtradores.isEmpty());
		assertTrue(filtradores .size() == 2);
		assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaCercana")));
		assertTrue(filtradores.stream().anyMatch(cls -> cls.getClass().getSimpleName().equals("DistanciaLejana")));
    }
}
