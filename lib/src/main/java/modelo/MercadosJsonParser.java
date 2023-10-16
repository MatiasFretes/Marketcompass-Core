package modelo;

import java.io.File;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MercadosJsonParser {

	public List<Mercado> obtenerMercados(String path) throws Exception{
		ObjectMapper mapper = new ObjectMapper(); 
	    return mapper.readValue(new File(path), new TypeReference<List<Mercado>>() {});
	}
}
