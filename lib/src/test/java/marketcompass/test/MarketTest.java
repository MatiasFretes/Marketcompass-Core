package marketcompass.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.marketcompass.modelo.Market;

public class MarketTest {

    @Test
    public void testMarket() {
        Market market = new Market("Nombre del mercado", "Direcci�n del mercado");
        assertEquals("Nombre del mercado", market.getNombre());
        assertEquals("Direcci�n del mercado", market.getDireccion());
    }
}