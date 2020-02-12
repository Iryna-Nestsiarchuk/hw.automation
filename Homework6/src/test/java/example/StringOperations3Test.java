package example;

import org.testng.Assert;
import org.testng.annotations.*;

public class StringOperations3Test {
    StringOperations stringOperations = new StringOperations();

    @Test(expectedExceptions = NumberFormatException.class)
    public void testConvertToNumberException() {
        stringOperations.convertToNumber("Hello");
    }

    @Test()
    public void testConvertToNumber() {
        Integer actualResult = stringOperations.convertToNumber("2");
        Integer expectedResult = 2;
        Assert.assertEquals(actualResult, expectedResult);
    }
}