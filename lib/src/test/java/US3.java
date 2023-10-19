import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import modelo.SugerenciaAPI;
import modelo.Sugeridor;

public class US3 {
	Sugeridor sugeridor;
	SugerenciaAPI sugerenciaAPI;
	List<String> listaProductosNula = null;
	List<String> listaProductosNoCategorizados = Arrays.asList("P1", "P2");
	List<String> listaProductosCategorizados = Arrays.asList("P3");
	List<String> listaSugerenciasVacia = Arrays.asList("");
	List<String> listaSugerencias = Arrays.asList("P4", "P5");
    
	@BeforeEach 
	public void setup() {
		sugerenciaAPI = Mockito.mock(SugerenciaAPI.class);
		sugeridor = new Sugeridor(sugerenciaAPI);
	}
	
	@Test
	public void CA1_ListaProductosVacia() {
		assertNull(sugeridor.sugerirProductos(listaProductosNula));
    }
	
	@Test
	public void CA2_ProductosNoCategorizados() {
        verify(listaProductosNoCategorizados, listaSugerenciasVacia);
	}
	
	@Test
	public void CA3_SugerenciasEncontradas() {
		verify(listaProductosCategorizados, listaSugerencias);
	}

	private void verify(List<String> input, List<String> output) {
		when(sugerenciaAPI.buscarSugerencias(input)).thenReturn(output);
        List<String> result = sugeridor.sugerirProductos(input);
        assertEquals(output, result);
	}
}
