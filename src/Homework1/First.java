package Homework1;

import java.util.Scanner;

//  Simple app which can get 2 args and print max value

public class First {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(maxValue(a, b));

    }

    public static int maxValue(int a, int b) {
        return (a > b ? a: b);
    }
}
