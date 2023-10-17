package modelo;

import java.util.List;

import extensible.FiltradorPorCriterio;
public class Recomendador {

	public FiltradorPorCriterio criterio;
	public List<Mercado> mercados;

    public Recomendador(FiltradorPorCriterio criterio, List<Mercado> mercados) {
    	this.criterio = criterio;
    	this.mercados = mercados;
    }

    public Recomendacion recomendar(List<String> productos){  	
    	BuscadorMercados buscadorMercados = new BuscadorMercados();
    	List<Mercado> mercadosConProductos = buscadorMercados.buscar(productos, mercados);    	
    	
    	if(mercadosConProductos == null || mercadosConProductos.isEmpty()) 
    		return new Recomendacion(null);
    	
    	Mercado mercadoRecomendado = criterio.filtrar(mercadosConProductos);
    	return new Recomendacion(mercadoRecomendado);
    }
   
}
