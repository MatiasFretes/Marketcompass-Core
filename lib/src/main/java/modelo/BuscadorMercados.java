package modelo;

import java.util.*;

public class BuscadorMercados {

	public List<Mercado> buscar (List<String> productos, List<Mercado> mercados) throws Exception {
		List<Mercado> mercadosConTodosLosProductos = new ArrayList<>();
		List<Mercado> mercadosConAlMenosUnProducto = new ArrayList<>();
		
		for (Mercado mercado : mercados) {
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
