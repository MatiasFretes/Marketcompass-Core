package modelo;

import java.util.List;
public class Recomendador {

    BuscadorMercados buscador;

    public Recomendador() {
        this.buscador = new BuscadorMercados();
    }

    public Mercado recomendar() throws Exception{  	
    	List<String> productos = PeticionUsuario.getProductos();
    	
    	if(productos == null)
            throw new IllegalArgumentException();

    	return buscador.buscar(productos);    	
    }
   
}
