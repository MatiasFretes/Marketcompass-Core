package modelo;

import java.util.List;
public class Recomendador {

    BuscadorMercados buscador;

    public Recomendador() {
        this.buscador = new BuscadorMercados();
    }

    public Mercado recomendar(List<String> productos) throws Exception{  	
    	if(productos == null)
            throw new IllegalArgumentException();

    	return buscador.buscar(productos);    	
    }
   
}
