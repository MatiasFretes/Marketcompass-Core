package modelo;

import java.util.List;

public class Sugeridor {
	
	private SugerenciaAPI sugeridorService;
	
	public Sugeridor() {
		this.sugeridorService = new SugerenciaAPI();
	}
	
	public Sugeridor(SugerenciaAPI sugeridorService) {
		this.sugeridorService = sugeridorService;
	}
	
	public List<String> sugerirProductos(List<String> productos){
		
		if(productos == null || productos.isEmpty())
			return null;
		
		return sugeridorService.buscarSugerencias(productos);
	}
}
