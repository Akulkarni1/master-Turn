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
    public void TestWithSingleProduct(){
        Product p = new Product();
        p.setName("Dove Soap");
        p.setPrice(BigDecimal.valueOf(39.30));

        Cart cart = new Cart();
        cart.populateMap(p,4);
        assertEquals(157.2,cart.getTotal().doubleValue());

    }
    @Test
    public void testWithDifferentProduct(){
        Product p = new Product();
        p.setName("Dove Soap");
        p.setPrice(BigDecimal.valueOf(39.30));

        Product p1 = new Product();
        p1.setName("Dove Soap");
        p1.setPrice(BigDecimal.valueOf(39.30));

        Cart cart = new Cart();
        cart.populateMap(p,4);
        cart.populateMap(p1,4);

        assertEquals(314.4,cart.getTotal().doubleValue());
        assertEquals(1,cart.getSize());
    }

}