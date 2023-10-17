import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import modelo.BuscadorMercados;
import modelo.CoreInit;
import modelo.Recomendacion;
import modelo.Sugeridor;
import service.SugeridorService;

public class US3 {
	Sugeridor sugeridor;
	SugeridorService sugeridorService;
	List<String> listaProductosNula = null;
	List<String> listaSugerenciasVacia = Arrays.asList("");

	
	@BeforeEach 
	public void setup() {
		sugeridorService = Mockito.mock(SugeridorService.class);
		sugeridor = new Sugeridor(sugeridorService);
	}
	
	@Test
	public void CA1_ListaProductosVacia() {
		assertNull(sugeridor.sugerirProductos(listaProductosNula));
    }
	
	@Test
	public void CA2_ProductosNoCategorizados() {
		//SugeridorService sugeridorService2= Mockito.mock(SugeridorService.class);
		//Sugeridor sugeridor2 = new Sugeridor(sugeridorService2);
		List<String> input = Arrays.asList("producto1", "producto2");
        //when(sugeridorService.obtenerSugerencias(input)).thenReturn(listaSugerenciasVacia);
        //List<String> result = sugeridor.sugerirProductos(input);
        //assertEquals(listaSugerenciasVacia, result);
        verify(input, listaSugerenciasVacia);
	}
	
	@Test
	public void CA3_SugerenciasEncontradas() {
		List<String> input = Arrays.asList("leche");
        List<String> output = Arrays.asList("queso", "yogur");
        verify(input, output);
	}

	private void verify(List<String> input, List<String> output) {
		
		when(sugeridorService.obtenerSugerencias(input)).thenReturn(output);
        List<String> result = sugeridor.sugerirProductos(input);
        assertEquals(output, result);
	}
}
