package modelo;

import configuracion.ConfiguracionRutas;

public class Inicializador {
	
	public Recomendacion inicializar() throws Exception {
		String rutaJsonMercados = ConfiguracionRutas.getRutaJsonMercados();
		iniciarMercados(rutaJsonMercados);
		return new Recomendacion();
	}

	public void iniciarMercados(String rutaJsonMercados) throws Exception {
		ProveedorMercados.obtenerMercados(rutaJsonMercados);
	}
}