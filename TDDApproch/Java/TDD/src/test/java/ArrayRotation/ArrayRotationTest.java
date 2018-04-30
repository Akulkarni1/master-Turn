package ArrayRotation;

import org.junit.Assert;
import org.junit.Test;

public class ArrayRotationTest {
    @Test
    public void rotateArrayByZero(){
        int [] array = {1,2,3,4,5,6,7};
        int rotateBy = 0;
        RotateArray r = new RotateArray(array.length);
        r.rotate(array,rotateBy);
        Assert.assertArrayEquals(array,r.rotate(array,rotateBy));
    }
    @Test
    public void rotateArrayBy3(){
        int [] array = {1,2,3,4,5,6,7};
        int rotateBy = 3;
        RotateArray r = new RotateArray(array.length);
        r.rotate(array,rotateBy);
        int temp []  ={4,5,6,7,1,2,3};
        Assert.assertArrayEquals(temp,r.rotate(array,rotateBy));

    }

    //test cases to find the element in the Rotoated array.
    @Test
    public void findTheElementInRotateArray(){
        int roatatedArray [] ={4,5,6,7,1,2,3};
        int findTheElement = 2;
        RotateArray r = new RotateArray(roatatedArray.length);
        Assert.assertEquals(5,r.findLoc(roatatedArray,findTheElement));
    }
}
