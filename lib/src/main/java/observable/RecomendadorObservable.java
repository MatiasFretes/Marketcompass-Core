package observable;

import java.util.List;
import java.util.Observable;

import extensible.FiltradorPorCriterio;
import modelo.Mercado;

public class RecomendadorObservable extends Observable {
    public List<String> productos;
    public String mercadoRecomendado;
    public String criterioUtilizado;

    public RecomendadorObservable() {
    }

    public void notificarRecomendacion(Mercado mercadoRecomendado, List<String> productos, FiltradorPorCriterio criterioUtilizado) {
        this.mercadoRecomendado = mercadoRecomendado.getNombre();
        this.productos = productos;
        this.criterioUtilizado = criterioUtilizado.getClass().getSimpleName();
        setChanged();
        notifyObservers(this);
    }
}
