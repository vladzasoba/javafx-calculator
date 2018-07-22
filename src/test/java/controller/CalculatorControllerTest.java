package controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.CalculatorService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CalculatorControllerTest {
    @Mock
    private CalculatorService calculatorServiceMock;
    @Mock
    private RadioButton radioButtonMock;
    @Mock
    private TextField textBoxMock;
    private TextField textBox;
    @Mock
    private Button buttonMock;
    private Button button = new Button();
    private CalculatorController calculatorController;
    private double firstOperand = 10;
    private double secondOperand = 15.5;
    private double expectedResult;
    private ActionEvent actionEvent;

    @BeforeClass
    public static void setUpJavaFX() {
        JFXPanel jfxPanel = new JFXPanel();
    }

    @Before
    public void setUp() {
        calculatorController = new CalculatorController();
        textBox = new TextField();
        calculatorController.setTextBox(textBox);
    }

    @Test
    public void printSymbolTestButtonContainsText() {
        String expectedSymbol = "7";
        button = new Button();
        button.setText(expectedSymbol);
        actionEvent = new ActionEvent(button, null);
        calculatorController.printSymbol(actionEvent);

        Assert.assertEquals(expectedSymbol, calculatorController.getTextBox().getText());
    }


    @Test
    public void printSymbolTestSetsTextField() {
        String expectedSymbol = "1";
        Mockito.when(buttonMock.getText()).thenReturn(expectedSymbol);
        actionEvent = new ActionEvent(buttonMock, null);
        calculatorController.printSymbol(actionEvent);

        Assert.assertEquals(expectedSymbol, textBox.getText());
    }

    @Test
    public void printSymbolTestConcatenatesTextBoxValue() {
        String expectedString = "23";
        String beginTextBoxValue = "2";
        String testSymbol = "3";
        button = new Button();
        button.setText(testSymbol);
        calculatorController.getTextBox().setText(beginTextBoxValue);
        actionEvent = new ActionEvent(button, null);

        calculatorController.printSymbol(actionEvent);

        Assert.assertEquals(expectedString, calculatorController.getTextBox().getText());
    }

    @Test
    public void printSymbolTestForbidsDoublePointTyping() {
        String expectedString = "0.";
        String beginTextBoxValue = "0";
        String testSymbol = ".";
        button = new Button();
        button.setText(testSymbol);
        calculatorController.getTextBox().setText(beginTextBoxValue);
        actionEvent = new ActionEvent(button, null);

        calculatorController.printSymbol(actionEvent);
        calculatorController.printSymbol(actionEvent);

        Assert.assertEquals(expectedString, calculatorController.getTextBox().getText());
    }

    @Test
    public void defineOperationTestSetsFirstOperand() {
        BinaryOperation expectedOperation = BinaryOperation.SUBTRACT;
        String textBoxBeginValue = "124.53";
        String testSymbol = "-";
        expectedResult = Double.parseDouble(textBoxBeginValue);
        button = new Button();
        button.setText(testSymbol);
        calculatorController.getTextBox().setText(textBoxBeginValue);
        actionEvent = new ActionEvent(button, null);

        calculatorController.defineOperation(actionEvent);
        firstOperand = calculatorController.getFirstOperand();
        Assert.assertTrue(expectedResult == firstOperand);
    }

    @Test
    public void defineOperationTestSetsAddOperation() {
        Mockito.when(buttonMock.getText()).thenReturn("+");
        ActionEvent actionEvent = new ActionEvent(buttonMock, null);
        calculatorController.defineOperation(actionEvent);

        BinaryOperation expectedOperation = BinaryOperation.ADD;
        BinaryOperation actualOperation = calculatorController.getOperation();
        Assert.assertEquals(expectedOperation, actualOperation);
    }

    @Test
    public void defineAndPerformUnaryOperationTest() {
        Mockito.when(buttonMock.getText()).thenReturn("sin");
        Mockito.when(textBoxMock.getText()).thenReturn(firstOperand + "");
        Mockito.when(radioButtonMock.isSelected()).thenReturn(true);
        expectedResult = Math.sin(Math.toRadians(firstOperand));
        calculatorController.setDeg(radioButtonMock);
        calculatorController.setTextBox(textBoxMock);
        actionEvent = new ActionEvent(buttonMock, null);

        calculatorController.defineAndPerformUnaryOperation(actionEvent);
        double actualResult = calculatorController.getResult();

        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void performOperationTest() {
        Mockito.when(buttonMock.getText()).thenReturn("+");
        Mockito.when(textBoxMock.getText()).thenReturn(secondOperand + "");
        expectedResult = firstOperand + secondOperand;
        actionEvent = new ActionEvent(buttonMock, null);

        calculatorController.setFirstOperand(firstOperand);
        calculatorController.setTextBox(textBoxMock);
        calculatorController.setOperation(BinaryOperation.ADD);

        calculatorController.performOperation(actionEvent);
        double actualResult = calculatorController.getResult();
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void doClearTest() {
        String expectedValue = "";
        calculatorController.getTextBox().setText("Test Test");

        calculatorController.doClear(null);
        String actualValue = calculatorController.getTextBox().getText();

        Assert.assertTrue(expectedValue.equals(actualValue));
    }
}
