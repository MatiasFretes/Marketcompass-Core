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

	@Override
	public String toString() {
		return "Recomendacion [mercado=" + mercado + "]";
	}
}
