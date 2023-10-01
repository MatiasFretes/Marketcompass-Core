package main;

import java.util.Arrays;
import modelo.Core;
import modelo.Inicializador;
import modelo.Recomendacion;

public class Main {

	public static void main(String[] args) throws Exception {
		Inicializador inicializador = new Inicializador();
		Recomendacion recomendador = inicializador.inicializar();
		Core core = new Core();
		core.recomendar(Arrays.asList("Arroz"), recomendador);
	}

}
