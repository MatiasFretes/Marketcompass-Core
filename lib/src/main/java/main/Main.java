package main;

import java.util.Arrays;
import modelo.Core;
import modelo.CoreInit;
import modelo.Recomendacion;

public class Main {

	public static void main(String[] args) throws Exception {
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		Recomendacion recomendacion = core.recomendar(Arrays.asList("Arroz"));
		System.out.println(recomendacion);
		
	}

}
