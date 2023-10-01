package modelo;

import java.util.*;

public class BuscadorMercados {

	public Mercado buscar(List<String> productos) throws Exception{
	    List<Mercado> mercadosConProductos = obtenerMercadosConMayoriaDeProductos(productos, ProveedorMercados.MERCADOS);
	    Mercado mercadoRecomendado = Criterio.CRITERIO.filtrar(mercadosConProductos);
	    return mercadoRecomendado;
    }

	private List<Mercado> obtenerMercadosConMayoriaDeProductos(List<String> productos, List<Mercado> todosMercados) throws Exception {
		List<Mercado> mercadosConProductos = new ArrayList<>();
		
	    int maxProductos = 0;
	    
	    for (Mercado mercado : todosMercados) {
	        List<String> productosMercado = mercado.getProductos();  
	        if (productosMercado.containsAll(productos)) {
	            mercadosConProductos.add(mercado);
	        } else if (productosMercado.size() > maxProductos) {
	            maxProductos = productosMercado.size();
	            mercadosConProductos.clear();
	            mercadosConProductos.add(mercado);
	        } else if (productosMercado.size() == maxProductos) {
	            mercadosConProductos.add(mercado);
	        }
	    }
	    
	    if (mercadosConProductos.isEmpty()) 
	        throw new Exception("No se encontraron mercados que comercialicen los productos solicitados.");
	    
		return mercadosConProductos;
	}
}
