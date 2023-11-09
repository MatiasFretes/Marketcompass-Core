package modelo;

public class Recomendacion {
	
	private String mercado;
	
	public Recomendacion() {
		
	}
	
	public Recomendacion(String mercado) {
		this.mercado = mercado;
	}

	public String getMercado() {
		return mercado;
	}
	

//	@Override
//	public String toString() {
//		return isEmpty() ? "Lo sentimos, el sistema no ha encontrado ninguna recomendacion de mercado en este momento." : "Se recomienda el mercado: " + mercado.getNombre();
//	}
}
