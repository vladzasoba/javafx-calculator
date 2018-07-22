package service;

public class CalculatorService {
    private double memoryBuffer;

    public double add(double op1, double op2) {
      return op1 + op2;
    }

    public double subtract(double op1, double op2) {
        return op1 - op2;
    }

    public double multiply(double op1, double op2) {
        return op1 * op2;
    }

    public double divide(double op1, double op2) {
        return op1 / op2;
    }

    public double sineOf(double op1, boolean deg) {
        if (deg) {
            op1 = Math.PI * op1 / 180;
        }
        return Math.sin(op1);
    }

    public double cosineOf(double op1, boolean deg) {
        if (deg) {
            op1 = Math.PI * op1 / 180;
        }
        return Math.cos(op1);
    }

    public double tangentOf(double op1, boolean deg) {
        if (deg) {
            op1 = Math.PI * op1 / 180;
        }
        return Math.tan(op1);
    }

    public double contangentOf(double op1, boolean deg) {
        return cosineOf(op1, deg) / sineOf(op1, deg);
    }

    public double pow2(double op1) {
        return Math.pow(op1, 2);
    }

    public double powY(double op1, double op2) {
        return Math.pow(op1, op2);
    }

    public double expX(double op1) {
        return Math.pow(Math.E, op1);
    }

    public double sqrtX(double op1) {
        return Math.sqrt(op1);
    }

    public double yRootX(double op1, double op2) {
        return Math.pow(op1, 1 / op2);
    }

    public double log(double op1) {
        return Math.log(op1);
    }

    public double log10(double op1) {
        return Math.log10(op1);
    }

    public double getMemoryBuffer() {
        return memoryBuffer;
    }

    public void setMemoryBuffer(double memoryBuffer) {
        this.memoryBuffer = memoryBuffer;
    }
}
