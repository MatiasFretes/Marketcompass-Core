package observable;

import java.util.List;
import java.util.Observable;

import extensible.FiltradorPorCriterio;
import modelo.Mercado;

public class RecomendadorObservable extends Observable {
    private List<String> productos;
    private Mercado mercadoRecomendado;
    private FiltradorPorCriterio criterioUtilizado;

    public RecomendadorObservable() {
    }

    public void notificarRecomendacion(Mercado mercadoRecomendado, List<String> productos, FiltradorPorCriterio criterioUtilizado) {
        this.mercadoRecomendado = mercadoRecomendado;
        this.productos = productos;
        this.criterioUtilizado = criterioUtilizado;
        setChanged();
        notifyObservers(this);
    }

    public List<String> getProductos() {
        return productos;
    }

    public Mercado getMercadoRecomendado() {
        return mercadoRecomendado;
    }

	public FiltradorPorCriterio getCriterioUtilizado() {
		return criterioUtilizado;
	}
}
