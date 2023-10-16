package modelo;

import java.util.List;
import extensible.FiltradorPorCriterio;
import observable.RecomendadorObservable;

public class Recomendador {
	public List<Mercado> mercados;
    public RecomendadorObservable recomendadorObservable;

    public Recomendador(List<Mercado> mercados, RecomendadorObservable recomendadorObservable) {
    	this.mercados = mercados;
        this.recomendadorObservable = recomendadorObservable;
    }

    public Recomendacion recomendar(FiltradorPorCriterio criterio, List<String> productos){  	
    	BuscadorMercados buscadorMercados = new BuscadorMercados();
    	List<Mercado> mercadosConProductos = buscadorMercados.buscar(productos, mercados);    	
    	
    	if(mercadosConProductos == null || mercadosConProductos.isEmpty()) 
    		return new Recomendacion(null);
  
    	Mercado mercadoRecomendado = criterio.filtrar(mercadosConProductos);
    	recomendadorObservable.notificarRecomendacion(mercadoRecomendado, productos, criterio);

    	return new Recomendacion(mercadoRecomendado);
	}
}
   

