package org.example;

public class Task_2 {

    public static void swap(int[] a, int[] b) {
        a[0] = (a[0] * b[0]) / (b[0] = a[0]);
    }
    public static void main(String[] args) {
        int[] a = { 1 };
        int[] b = { 4 };
        System.out.println("a = " + a[0]);
        System.out.println("b = " + b[0]);

        System.out.println("swap");

        swap(a, b);
        System.out.println("a = " + a[0]);
        System.out.println("b = " + b[0]);
    }
}
