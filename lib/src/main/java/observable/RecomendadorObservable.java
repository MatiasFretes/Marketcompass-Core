package observable;

import java.util.List;
import java.util.Observable;

import modelo.Mercado;

public class RecomendadorObservable extends Observable {
    private List<String> productos;
    private Mercado mercadoRecomendado;

    public RecomendadorObservable() {
    }

    public void notificarRecomendacion(Mercado mercadoRecomendado, List<String> productos) {
        this.mercadoRecomendado = mercadoRecomendado;
        this.productos = productos;
        setChanged();
        notifyObservers(this);
    }

    public List<String> getProductos() {
        return productos;
    }

    public Mercado getMercadoRecomendado() {
        return mercadoRecomendado;
    }
}
