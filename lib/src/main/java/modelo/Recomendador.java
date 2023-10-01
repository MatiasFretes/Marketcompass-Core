package modelo;

import java.util.List;
public class Recomendador {

    BuscadorMercados buscador;

    public Recomendador() {
        this.buscador = new BuscadorMercados();
    }

    public void recomendar(List<String> productos, Recomendacion recomendacion) throws Exception{
    	if(productos == null || productos.isEmpty())
            throw new IllegalArgumentException();

    	Mercado mercado = buscador.buscar(productos);    	
    	recomendacion.setMercado(mercado);
    }
   
}
