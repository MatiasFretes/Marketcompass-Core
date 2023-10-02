package modelo;

public class Recomendacion {
	
	private Mercado mercado;
	
	public Recomendacion() {
		
	}
	
	public Recomendacion(Mercado mercado) {
		this.mercado = mercado;
	}

	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}
	
	public boolean isEmpty() {
		return this.mercado == null || this.mercado.getNombre().isEmpty() || this.mercado.getProductos().isEmpty();
	}

	@Override
	public String toString() {
		return "Recomendacion [mercado=" + mercado + "]";
	}
}
