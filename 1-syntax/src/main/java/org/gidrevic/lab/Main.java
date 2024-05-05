package org.gidrevic.lab;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random random = new Random();

    private static int getRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Define length of an array:");

        int length = input.nextInt();
        System.out.println("Define bounds of an array values:");

        int min = input.nextInt();
        int max = input.nextInt();

        if (max < min) {
            throw new IllegalArgumentException("Invalid bounds for values!");
        }

        int [] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandom(min, max);
        }

        System.out.println("Filled array:");
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.println("Swapped array:");
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (i == 0 && array.length > 1) {
                value = array[i + 1];
            } else if (i == array.length - 1 && array.length > 1) {
                value = array[i - 1];
            } else if (array.length > 2) {
                value = (array[i - 1] + array[i] + array[i + 1]) / 3;
            }
            array[i] = value;
        }

        System.out.println(Arrays.toString(array));
    }
}