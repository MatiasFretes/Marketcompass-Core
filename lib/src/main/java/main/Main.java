package main;

import java.util.Arrays;
import modelo.Core;
import modelo.CoreInit;

public class Main {

	public static void main(String[] args){
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		System.out.println(core.obtenerNombresCriterios());
		
		String recomendacion = core.recomendar(Arrays.asList("manzana"));
		System.out.println(recomendacion);
	}

}
