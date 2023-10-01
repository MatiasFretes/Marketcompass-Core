package main;

import java.util.Arrays;
import modelo.Core;
import modelo.Inicializador;
import modelo.Recomendacion;

public class Main {

	public static void main(String[] args) throws Exception {
		Inicializador inicializador = new Inicializador();
		Recomendacion recomendacion = inicializador.inicializar();
		Core core = new Core();
		Recomendacion recomendacionDelCore = core.recomendar(Arrays.asList("Arroz"));
	}

}
