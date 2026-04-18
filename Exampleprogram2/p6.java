package com.lab2;

/*
p6. Write a Java program to check whether a TreeMap contains a specified key or not
*/



import java.util.*;

public class p6 {

    public static void main(String[] args) {

        Map<String, String> map1 = new TreeMap<>();

        map1.put("c1", "Red");
        map1.put("c2", "Green");
        map1.put("c3", "Black");
        map1.put("c4", "White");

        // Check keys
        System.out.println("Whether it contains c4 or not: " + map1.containsKey("c4"));
        System.out.println("Whether it contains c5 or not: " + map1.containsKey("c5"));
    }
}
