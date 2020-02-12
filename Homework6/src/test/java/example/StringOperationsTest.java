package example;

import org.testng.Assert;
import org.testng.annotations.*;

public class StringOperationsTest {
    StringOperations stringOperations = new StringOperations();

    @Test
    public void testCountWords() {
        int actualResult = stringOperations.countWords("Hello, my name is Ira");
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult, "ERROR!!!!");
    }

    @Test
    public void testLongestWordNegative() {
        String actualResult = stringOperations.longestWord("Hello, my name is Ira");
        String expectedResult = "Ira";
        Assert.assertEquals(actualResult, expectedResult, "ERROR!!!!");
    }

    @Test
    public void testLongestWord() {
        String actualResult = stringOperations.longestWord("Hello, my name is Ira");
        String expectedResult = "Hello";
        Assert.assertEquals(actualResult, expectedResult, "ERROR!!!!");
    }
}