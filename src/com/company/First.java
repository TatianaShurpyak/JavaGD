package com.company;

import java.util.Scanner;

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