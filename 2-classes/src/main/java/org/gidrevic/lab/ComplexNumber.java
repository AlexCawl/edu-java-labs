package org.gidrevic.lab;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static ComplexNumber fromReal(double real) {
        return new ComplexNumber(real, 0);
    }

    public static ComplexNumber fromImaginary(double imaginary) {
        return new ComplexNumber(0, imaginary);
    }

    public ComplexNumber add(ComplexNumber number) {
        return new ComplexNumber(this.real + number.real, this.imaginary + number.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber number) {
        return new ComplexNumber(this.real - number.real, this.imaginary - number.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber number) {
        return new ComplexNumber(
                this.real * number.real - this.imaginary * number.imaginary,
                this.real * number.imaginary + number.real * this.imaginary
        );
    }

    @Override
    public String toString() {
        if (this.imaginary >= 0) {
            return this.real + " + " + this.imaginary + "i";
        } else {
            return this.real + " - " + Math.abs(this.imaginary) + "i";
        }
    }
}
