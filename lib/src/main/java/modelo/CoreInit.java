package modelo;

import java.util.List;
import java.util.Set;

import configuracion.ConfiguracionRuta;
import extensible.BuscadorCriterio;
import extensible.SeleccionadorPorCriterio;

public class CoreInit {

	public String directorio = ConfiguracionRuta.obtenerDirectorio();
	public ProveedorMercados proveedorMercados;
	
	public CoreInit() {
		this.proveedorMercados = new ProveedorMercados();
	}
	      
	public Core inicializar() {
		try {	 
			List<String> mercados = proveedorMercados.obtenerMercados();

			BuscadorCriterio buscadorCriterios = new BuscadorCriterio(mercados);

			Set<SeleccionadorPorCriterio> criterios = buscadorCriterios.buscar(directorio);

			return new Core(criterios);
		} catch (Exception e) {
			return new Core(null);
		}
	}
	
	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}
	
	public void setProveedorMercados(ProveedorMercados proveedorMercados) {
		this.proveedorMercados = proveedorMercados;
	}
}