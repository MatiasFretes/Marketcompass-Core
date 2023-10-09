package modelo;

import java.util.Observable;

public class Recomendacion extends Observable{
	
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
		setChanged();
        notifyObservers(this.mercado);
	}
	
	public boolean isEmpty() {
		return this.mercado == null || this.mercado.getNombre().isEmpty() || this.mercado.getProductos().isEmpty();
	}

	@Override
	public String toString() {
		return isEmpty() ? "Lo sentimos, el sistema no ha encontrado ninguna recomendaci�n de mercado en este momento." : "Se recomienda el mercado: " + mercado.getNombre();
	}
}
