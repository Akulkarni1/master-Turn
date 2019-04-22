package Cart;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Cart {
    Map<Product,Integer> mapCart;
    public Cart(){
        mapCart = new HashMap<>();
    }
    public int getSize(){
        return mapCart.size();
    }
    public Map<Product, Integer> getMapCart() {
        return mapCart;
    }

    public void setMapCart(Map<Product, Integer> mapCart) {
        this.mapCart = mapCart;
    }

    public void populateMap(Product p, int quantity){
        if(mapCart.containsKey(p)) {
            mapCart.put(p, mapCart.get(p) + quantity);
        }
        else mapCart.put(p,quantity);
    }

    private List<BigDecimal> getTotalAmount(){
        List<BigDecimal> amount = new ArrayList<>();
        mapCart.entrySet().stream().forEach(e -> amount.add(e.getKey().getPrice().multiply(new BigDecimal(BigInteger.valueOf(e.getValue())))));
        return amount;
    }
    public BigDecimal getTotal(){
        BigDecimal bigDecimal =BigDecimal.ZERO;
        List<BigDecimal> amount= getTotalAmount();
        for(BigDecimal n:amount){
            bigDecimal = bigDecimal.add(n);
        }
        return bigDecimal;
     }




}
