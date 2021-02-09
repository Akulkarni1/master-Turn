import billgenerate.BillGenerate;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class TestBill {
    @Test
    public void testBillGenerate(){
        BillGenerate billGenerate = new BillGenerate();
        billGenerate.generateBill();

    }
}
