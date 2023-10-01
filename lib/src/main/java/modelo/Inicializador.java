package modelo;

import configuracion.ConfiguracionRutas;

public class Inicializador {
	
	public Recomendacion inicializar() throws Exception {
		String rutaJsonMercados = ConfiguracionRutas.getRutaJsonMercados();
		ProveedorMercados.iniciarMercados(rutaJsonMercados);
		return new Recomendacion();
	}
	
}