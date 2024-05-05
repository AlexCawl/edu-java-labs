package org.gidrevic.lab;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringMaximizer maximizer = (str1, str2) -> {
            if (str1.length() > str2.length()) {
                return str1;
            } else {
                return str2;
            }
        };

        System.out.println("Enter a string: ");
        String s = input.nextLine();
        System.out.println("Enter another string: ");
        String another = input.nextLine();
        System.out.printf("Selected string is: %s", maximizer.maximize(s, another));
    }
}