package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(fakeFib(7));
    }

    public static int fakeFib(int n){
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        return (int)(Math.pow(fakeFib(n-1),2)) + (int)(Math.pow(fakeFib(n-2),2));
    }
}
