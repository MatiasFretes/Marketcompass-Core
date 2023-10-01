package modelo;

import java.util.List;

public class Mercado {

	private String nombre;
	private List<String> productos;

	public Mercado() {
		
	}
	
	public Mercado(String nombre, List<String> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getProductos() {
		return productos;
	}

	public void setProductos(List<String> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Mercado [nombre=" + nombre + ", productos=" + productos + "]";
	}
}
