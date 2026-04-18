package com.lab2;

/*
p3. Write a Java program to merge two HashMaps
*/


import java.util.HashMap;
import java.util.Map;

public class p3 {

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();

        map1.put(1, "Red");
        map1.put(2, "Green");
        map1.put(3, "Black");

        Map<Integer, String> map2 = new HashMap<>();

        map2.put(4, "White");
        map2.put(5, "Blue");
        map2.put(6, "Orange");

        // Merge map2 into map1
        map1.putAll(map2);

        System.out.println("After merging maps: " + map1);
    }
}
