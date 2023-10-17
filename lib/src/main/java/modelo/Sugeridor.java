package modelo;

import java.util.List;

import service.SugeridorService;

public class Sugeridor {
	
	private SugeridorService sugeridorService;
	
	public Sugeridor() {
		this.sugeridorService = new SugeridorService();
	}
	
	public Sugeridor(SugeridorService sugeridorService) {
		this.sugeridorService = sugeridorService;
	}
	
	public List<String> sugerirProductos(List<String> productos){
		
		if(productos == null || productos.isEmpty())
			return null;
		
		return sugeridorService.obtenerSugerencias(productos);
	}
}
