package modelo;

import java.util.List;

public class PeticionUsuario {
	
	public static List<String> PRODUCTOS;

	public static void guardarProductos(List<String> productos) {
		PRODUCTOS = productos;
	}
	
	public static List<String> getProductos() {
		return PRODUCTOS;
	}
}
