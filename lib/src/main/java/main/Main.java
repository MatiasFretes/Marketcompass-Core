package main;

import java.util.Arrays;
import extensible.FiltradorPorCriterio;
import java.util.List;
import modelo.Core;
import modelo.CoreInit;
import modelo.Recomendacion;
import modelo.Sugeridor;

public class Main {

	public static void main(String[] args) throws Exception {
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		FiltradorPorCriterio criterio = core.criterios.stream().findFirst().get();
		Recomendacion recomendacion = core.obtenerRecomendacion(criterio, Arrays.asList("Arroz"));
		System.out.println(recomendacion);
		
	}

}
