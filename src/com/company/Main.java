package com.company;

import java.util.Scanner;

//Given a string s and a number n, find the last (from left to right) instance
//of a substring of s, which is a sequence of at least n repeating (same) symbols

public class Main {

    public static void main(String[] args) {
        String s;
        int n;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input original string: ");
            s = sc.nextLine();
            if (s == null || s.length() == 0 ) {
                System.out.println("Empty original string.");
                throw new IllegalArgumentException();
            }

            System.out.println("Input an integer: ");
            n = sc.nextInt();
            if (n <= 0) n = 1; //if n is not positive, any one symbol is a candidate

            //The last instance is the same as the first instance in a reversed string
            StringBuilder sb = (new StringBuilder(s)).reverse();
            StringBuilder answer = new StringBuilder(String.valueOf(sb.charAt(0)));
            for (int i = 1; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch == answer.charAt(0)) answer.append(ch);
                else {
                    if (answer.length() >= n) break;
                    else answer = new StringBuilder(String.valueOf(ch));//A lot of work for GC =(
                }
            }
            if (answer.length() >= n) System.out.println("Target substring: " + answer);
            else System.out.println("Target substring not found.");
        }
        catch(Exception e){
            System.out.println("Please put in valid parameters");
        }
    }
}
