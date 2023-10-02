package modelo;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProveedorMercados {
	
	public static List<Mercado> MERCADOS;
	
	public static void obtenerMercados(String path) throws Exception{
		ObjectMapper mapper = new ObjectMapper(); 
	    MERCADOS = mapper.readValue(new File(path), new TypeReference<List<Mercado>>() {});
	}

}
