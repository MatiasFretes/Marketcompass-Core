package modelo;

import java.util.List;

public class ProveedorMercados {
	
	public static List<Mercado> MERCADOS;

	public static void guardarMercados(List<Mercado> mercados) {
		MERCADOS = mercados;
	}
	
	public static List<Mercado> getMercados(){
		return MERCADOS;
	}
}
