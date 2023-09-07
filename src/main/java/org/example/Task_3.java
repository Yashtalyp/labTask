package org.example;

public class Task_3 {

    public static boolean palindrome(String s) {

        for(int i = 0; i<s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {

        String string1 = "tenet";
        String string2 = "hello";

        System.out.println(string1 + " " + palindrome(string1));
        System.out.println(string2 + " " + palindrome(string2));
    }
}
