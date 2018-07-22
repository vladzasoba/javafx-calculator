package service;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorSeviceTest {
    private double firstOperand = 10;
    private double secondOperand = 15.5;
    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void addTest() {
        double expectedResult = firstOperand + secondOperand;
        double actualResult = calculatorService.add(firstOperand, secondOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void subtractTest() {
        double expectedResult = firstOperand - secondOperand;
        double actualResult = calculatorService.subtract(firstOperand, secondOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void multiplyTest() {
        double expectedResult = firstOperand * secondOperand;
        double actualResult = calculatorService.multiply(firstOperand, secondOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void divideTest() {
        double expectedResult = firstOperand / secondOperand;
        double actualResult = calculatorService.divide(firstOperand, secondOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void sineOfTest() {
        double expectedResult = Math.sin(firstOperand);
        double actualResult = calculatorService.sineOf(firstOperand, false);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void sineOfInDegreesTest() {
        double expectedResult = Math.sin(Math.toRadians(firstOperand));
        double actualResult = calculatorService.sineOf(firstOperand, true);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void cosineOfTest() {
        double expectedResult = Math.cos(firstOperand);
        double actualResult = calculatorService.cosineOf(firstOperand, false);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void cosineOfDegreesTest() {
        double expectedResult = Math.cos(Math.toRadians(firstOperand));
        double actualResult = calculatorService.cosineOf(firstOperand, true);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void tangentOfTest() {
        double expectedResult = Math.tan(firstOperand);
        double actualResult = calculatorService.tangentOf(firstOperand, false);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void tangentOfDegreesTest() {
        double expectedResult = Math.tan(Math.toRadians(firstOperand));
        double actualResult = calculatorService.tangentOf(firstOperand, true);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void cotangentOfTest() {
        double expectedResult = Math.cos(firstOperand) / Math.sin(firstOperand);
        double actualResult = calculatorService.contangentOf(firstOperand, false);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void cotangentOfDegreesTest() {
        double expectedResult = Math.cos(Math.toRadians(firstOperand)) / Math.sin(Math.toRadians(firstOperand));
        double actualResult = calculatorService.contangentOf(firstOperand, true);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void pow2Test() {
        double expectedResult = Math.pow(firstOperand, 2);
        double actualResult = calculatorService.pow2(firstOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void powYTest() {
        double expectedResult = Math.pow(firstOperand, secondOperand);
        double actualResult = calculatorService.powY(firstOperand, secondOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void expXTest() {
        double expectedResult = Math.pow(Math.E, firstOperand);
        double actualResult = calculatorService.expX(firstOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void sqrtXTest() {
        double expectedResult = Math.sqrt(firstOperand);
        double actualResult = calculatorService.sqrtX(firstOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void yRootXTest() {
        double expectedResult = Math.pow(firstOperand, 1 / secondOperand);
        double actualResult = calculatorService.yRootX(firstOperand, secondOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void logXTest() {
        double expectedResult = Math.log(firstOperand);
        double actualResult = calculatorService.log(firstOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void log10Test() {
        double expectedResult = Math.log10(firstOperand);
        double actualResult = calculatorService.log10(firstOperand);
        Assert.assertTrue(expectedResult == actualResult);
    }
}
