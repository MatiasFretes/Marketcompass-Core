package extensible;

import java.util.List;

import modelo.Mercado;

public interface FiltradorPorCriterio {

	Mercado filtrar(List<Mercado> mercados);
	
}
