package com.lab2;

/*
p8. Write a Java program to display the first and last key in a TreeMap
*/



import java.util.*;

public class p8 {

    public static void main(String[] args) {

        TreeMap<String, String> map1 = new TreeMap<>();

        map1.put("c2", "Red");
        map1.put("c1", "Green");
        map1.put("c4", "Black");
        map1.put("c3", "White");

        System.out.println("TreeMap: " + map1);

        // First and last keys
        System.out.println("The first key is: " + map1.firstKey());
        System.out.println("The last key is: " + map1.lastKey());
    }
}
