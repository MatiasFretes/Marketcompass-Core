package main;

import java.util.Arrays;
import modelo.Core;
import modelo.Recomendacion;

public class Main {

	public static void main(String[] args) throws Exception {
		Core core = new Core(Arrays.asList("P3"));		
		Recomendacion recomendacion = core.recomendar();
		System.out.println(recomendacion);
	}

}
