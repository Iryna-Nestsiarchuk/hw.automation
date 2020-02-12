package example;

import org.testng.Assert;
import org.testng.annotations.*;

public class StringOperations2Test {
    StringOperations stringOperations = new StringOperations();

    @DataProvider
    public Object[][] getStrings() {
        return new Object[][]{
                {"abc", "cba"},
                {"Hello", "olleH"},
                {"yes", "sey"}
        };
    }

    @Test(dataProvider = "getStrings")
    public void testReverse(String line, String expectedResult) {
        String actualResult = stringOperations.reverse(line);
        Assert.assertEquals(actualResult, expectedResult, "ERROR!!!!");
    }

    @Test()
    public void isFirstVowelTrue() {
        boolean actualResult = stringOperations.isFirstVowel("Iryna Nestsiarchuk");
        Assert.assertTrue(actualResult);
    }

    @Test(enabled = false)
    public void isFirstVowelFalse() {
        boolean actualResult = stringOperations.isFirstVowel("Hello");
        Assert.assertFalse(actualResult);
    }
}