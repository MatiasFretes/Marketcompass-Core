package modelo;

import configuracion.Configuracion;

public class Inicializador {
	public Recomendacion inicializar() throws Exception {
		String rutaJsonMercados = Configuracion.getRutaJsonMercados();
		ProveedorMercados.iniciarMercados(rutaJsonMercados);
		return new Recomendacion();
	}
}