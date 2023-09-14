package extensible;

import org.apache.commons.math3.util.Pair;

import java.util.List;
import java.util.Map;

public interface FiltradorPorCriterio {

	Pair<String, List<String>> filtrar(Map<String, List<String>> mercados);
}
