package modelo;

import java.util.List;

import extensible.FiltradorPorCriterio;
import observable.RecomendadorObservable;
public class Recomendador {

	public FiltradorPorCriterio criterio;
	public List<Mercado> mercados;
    private RecomendadorObservable recomendadorObservable;

    public Recomendador(FiltradorPorCriterio criterio, List<Mercado> mercados, RecomendadorObservable recomendadorObservable) {
    	this.criterio = criterio;
    	this.mercados = mercados;
        this.recomendadorObservable = recomendadorObservable;
    }

    public Recomendacion recomendar(List<String> productos){  	
    	BuscadorMercados buscadorMercados = new BuscadorMercados();
    	List<Mercado> mercadosConProductos = buscadorMercados.buscar(productos, mercados);    	
    	
    	if(mercadosConProductos == null || mercadosConProductos.isEmpty()) 
    		return new Recomendacion(null);
    	
    	Mercado mercadoRecomendado = criterio.filtrar(mercadosConProductos);
    	recomendadorObservable.notificarRecomendacion(mercadoRecomendado, productos);
    	return new Recomendacion(mercadoRecomendado);
    }
   
}
