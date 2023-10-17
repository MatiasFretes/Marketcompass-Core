import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import extensible.FiltradorPorCriterio;
import modelo.Core;
import modelo.CoreInit;
import modelo.Recomendacion;

class US4 {
    private CoreInit coreInit;
    private Core core;
    private String rutaJsonMercados = "src/test/resources/mercados.json";
    private String rutaJarCriterio = "src/test/resources/DistanciasMultiples.jar";
    private List<String> productoExistente = Arrays.asList("P3");
    private String mercadoEsperadoCercano = "M1";
    private String mercadoEsperadoLejano = "M2";
    private FiltradorPorCriterio criterioVacio = null;
    private FiltradorPorCriterio criterioDistanciaCercana;
    private FiltradorPorCriterio criterioDistanciaLejana;
    private Set<FiltradorPorCriterio> criterios;

    @BeforeEach
    public void setup() {
        CoreInit.RUTA_JSON_MERCADOS = rutaJsonMercados;
        CoreInit.RUTA_JAR_CRITERIO = rutaJarCriterio;
        coreInit = new CoreInit();
        core = coreInit.inicializar();
        criterios = core.criterios;
    }

    @Test
    public void CA1_CriterioNoSeleccionado() {
        Recomendacion recomendacion = core.obtenerRecomendacion(criterioVacio, productoExistente);
        assertTrue(recomendacion.toString().equals("Lo sentimos, el sistema no ha encontrado ninguna recomendacion de mercado en este momento."));
    }

  @Test
   public void CA2_DistanciasMultiples() {	
       List<FiltradorPorCriterio> listaCriterios = new ArrayList<>(criterios);
       criterioDistanciaCercana = listaCriterios.get(1);
       criterioDistanciaLejana = listaCriterios.get(0);
       
       Recomendacion recomendacionCercana = core.obtenerRecomendacion(criterioDistanciaCercana, productoExistente);
       Recomendacion recomendacionLejana = core.obtenerRecomendacion(criterioDistanciaLejana, productoExistente);
       
       assertTrue(recomendacionCercana.getMercado().getNombre().equals(mercadoEsperadoCercano));
       assertTrue(recomendacionLejana.getMercado().getNombre().equals(mercadoEsperadoLejano));
    }

}

