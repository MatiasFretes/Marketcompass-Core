package main;

import java.util.Arrays;

import modelo.Core;
import modelo.CoreInit;
import modelo.Recomendacion;

public class Main {

	public static void main(String[] args){
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		System.out.println(core.obtenerNombresCriterios());
		
		Recomendacion recomendacion = core.recomendar(Arrays.asList("P2"));
		System.out.println(recomendacion.getMercado());
	}

}
