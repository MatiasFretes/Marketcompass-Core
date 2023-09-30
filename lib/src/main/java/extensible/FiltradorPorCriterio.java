package extensible;

import com.marketcompass.modelo.Mercado;
import java.util.List;

public interface FiltradorPorCriterio {

	Mercado filtrar(List<Mercado> mercados);
	
}
