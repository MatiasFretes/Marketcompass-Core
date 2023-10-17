package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Core;
import modelo.CoreInit;
import modelo.Recomendacion;
import modelo.Sugeridor;

public class Main {

	public static void main(String[] args) throws Exception {
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		Recomendacion recomendacion = core.obtenerRecomendacion(Arrays.asList("Arroz"));
		System.out.println(recomendacion);
		
		Sugeridor sugeridor = new Sugeridor();
		System.out.println(sugeridor.sugerirProductos(List.of("mayonesa")));

	}

}
