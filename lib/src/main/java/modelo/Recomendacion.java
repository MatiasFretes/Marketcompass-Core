package modelo;

public class Recomendacion {
	
	private Mercado mercado;
	private String mensaje;
	
	public Recomendacion() {
		
	}
	
	public Recomendacion(Mercado mercado, String mensaje) {
		this.mercado = mercado;
		this.mensaje = mensaje;
	}

	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Recomendacion [mercado=" + mercado + ", mensaje=" + mensaje + "]";
	}
}
