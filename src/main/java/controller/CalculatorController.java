package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import service.CalculatorService;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    @FXML
    private TextField textBox;
    @FXML
    private RadioButton deg;
    private double firstOperand;
    private double secondOperand;
    double result = 0;
    private BinaryOperation operation;

    private CalculatorService calculatorService = new CalculatorService();

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void printSymbol(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();

        if (source.getText().equals(".") && textBox.getText().contains(".")) {
            return;
        } else if (source.getText().equals("\u03c0")) {
            textBox.setText(textBox.getText() + Math.PI);
            return;
        }
        textBox.setText(textBox.getText() + source.getText());
    }

    public void defineAndPerformUnaryOperation(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        String text = source.getText();
        firstOperand = (textBox.getText().isEmpty()) ? 0:  Double.parseDouble(textBox.getText());
        result = 0;

        switch (text) {
            case "sin":
                result = calculatorService.sineOf(firstOperand, deg.isSelected());
                break;
            case "cos":
                result = calculatorService.cosineOf(firstOperand, deg.isSelected());
                break;
            case "tan":
                result = calculatorService.tangentOf(firstOperand, deg.isSelected());
                break;
            case "ctg":
                result = calculatorService.contangentOf(firstOperand, deg.isSelected());
                break;
            case "x\u00b2":
                result = calculatorService.pow2(firstOperand);
                break;
            case "e\u02b8":
                result = calculatorService.expX(firstOperand);
                break;
            case "\u221ax":
                result = calculatorService.sqrtX(firstOperand);
                break;
            case "ln\u03c7":
                result = calculatorService.log(firstOperand);
                break;
            case "lg\u03c7":
                result = calculatorService.log10(firstOperand);
                break;
        }

        textBox.setText(result + "");
    }

    public void defineOperation(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        String text = source.getText();
        firstOperand = (textBox.getText().isEmpty()) ? 0:  Double.parseDouble(textBox.getText());
        textBox.setText("");
        switch (text) {
            case "+" :
                operation = BinaryOperation.ADD;
                break;
            case "-":
                operation = BinaryOperation.SUBTRACT;
                break;
            case "*":
                operation = BinaryOperation.MULTIPLY;
                break;
            case "/":
                operation = BinaryOperation.DIVIDE;
                break;
            case "x\u02b8":
                operation = BinaryOperation.POW;
                break;
            case "\u02b8\u221ax":
                operation = BinaryOperation.YROOTOF;
                break;
        }
    }

    public void performOperation(ActionEvent actionEvent) {
        result = 0;
        secondOperand = (textBox.getText().isEmpty()) ? 0 :  Double.parseDouble(textBox.getText());

        if (secondOperand == 0 && operation == BinaryOperation.DIVIDE) {
            textBox.setText("Error: division by 0");
            return;
        }

        switch (operation) {
            case ADD:
                result = calculatorService.add(firstOperand, secondOperand);
                break;
            case SUBTRACT:
                result = calculatorService.subtract(firstOperand, secondOperand);
                break;
            case MULTIPLY:
                result = calculatorService.multiply(firstOperand, secondOperand);
                break;
            case DIVIDE:
                result = calculatorService.divide(firstOperand, secondOperand);
                break;
            case POW:
                result = calculatorService.powY(firstOperand, secondOperand);
                break;
            case YROOTOF:
                result = calculatorService.yRootX(firstOperand, secondOperand);
                break;
        }

        textBox.setText(result + "");
    }

    public void doClear(ActionEvent actionEvent) {
        textBox.setText("");
        operation = null;
    }


    public void addToMemory(ActionEvent actionEvent) {
        double operand = (textBox.getText().isEmpty()) ? 0 : Double.parseDouble(textBox.getText());
        calculatorService.setMemoryBuffer(calculatorService.getMemoryBuffer() + operand);
        textBox.setText(calculatorService.getMemoryBuffer() + "");
    }


    public void subtractFromMemory(ActionEvent actionEvent) {
        double operand = (textBox.getText().isEmpty()) ? 0 : Double.parseDouble(textBox.getText());
        calculatorService.setMemoryBuffer(calculatorService.getMemoryBuffer() - operand);
        textBox.setText(calculatorService.getMemoryBuffer() + "");
    }

    public void clearMemory(ActionEvent actionEvent) {
        calculatorService.setMemoryBuffer(0);
    }

    public void setTextBox(TextField textBox) {
        this.textBox = textBox;
    }

    public void setOperation(BinaryOperation operation) {
        this.operation = operation;
    }

    public BinaryOperation getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public TextField getTextBox() {
        return textBox;
    }

    public RadioButton getDeg() {
        return deg;
    }

    public void setDeg(RadioButton deg) {
        this.deg = deg;
    }

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
}
