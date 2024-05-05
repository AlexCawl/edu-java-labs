package org.gidrevic.lab;

public class Main {
    public static void main(String[] args) {
        int value = 9;
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(-1, 1);

        System.out.println("Addition:");
        System.out.printf("(%s) + (%s) = %s\n", num1, num2, num1.add(num2));

        System.out.println("Substraction:");
        System.out.printf("(%s) - (%s) = %s\n", num1, num2, num1.subtract(num2));

        System.out.println("Multiplication:");
        System.out.printf("(%s) * (%s) = %s\n", num1, num2, num1.multiply(num2));

        System.out.println("Complex number from real number:");
        System.out.printf("%d = %s\n", value, ComplexNumber.fromReal(value));

        System.out.println("Complex number from imaginary number:");
        System.out.printf("%di = %s\n", value, ComplexNumber.fromImaginary(value));
    }
}