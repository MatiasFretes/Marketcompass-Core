package modelo;

import java.util.*;

public class BuscadorMercados {

	public Mercado buscar(List<String> productos) throws Exception{
	    List<Mercado> mercadosConProductos = obtenerMercadosConMayoriaDeProductos(productos);
	    if(mercadosConProductos == null ) return null;
	    //System.out.println("Mercados que comercializan los productos: " + productos + " son: " + mercadosConProductos);
	    Mercado mercadoRecomendado = Criterio.CRITERIO.filtrar(mercadosConProductos);
	    return mercadoRecomendado;
    }

	private List<Mercado> obtenerMercadosConMayoriaDeProductos(List<String> productos) throws Exception {
		List<Mercado> todosMercados = ProveedorMercados.getMercados();
		List<Mercado> mercadosConTodosLosProductos = new ArrayList<>();
		List<Mercado> mercadosConAlMenosUnProducto = new ArrayList<>();
		
		for (Mercado mercado : todosMercados) {
		    List<String> productosMercado = mercado.getProductos();
		    if (productosMercado.containsAll(productos))
		        mercadosConTodosLosProductos.add(mercado);
		    
		    if (!Collections.disjoint(productosMercado, productos)) 
		        mercadosConAlMenosUnProducto.add(mercado);
		}
		
		if (!mercadosConTodosLosProductos.isEmpty()) 
			return mercadosConTodosLosProductos;
		else if (!mercadosConAlMenosUnProducto.isEmpty()) 
		    return mercadosConAlMenosUnProducto;
		else 
		    return null;
	}
}
