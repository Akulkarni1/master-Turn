import Cart.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;

public class ShoppingCartTest {
    @Test
    public void TestWithNoProduct(){
        Cart c= new Cart();
        assertEquals(0,c.getTotal().intValueExact());
    }
    @Test
    public void TestWithDifferentProduct(){
        Product p = new Product();
        p.setName("Dove Soap");
        p.setPrice(BigDecimal.valueOf(39.30));

        Cart cart = new Cart();
        cart.populateMap(p,4);
        assertEquals(157.2,cart.getTotal().doubleValue());
    }
}