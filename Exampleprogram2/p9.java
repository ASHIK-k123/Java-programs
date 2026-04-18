package com.lab2;

/*
p9. Write a Java program to demonstrate LinkedHashMap with removeEldestEntry()
to maintain only 4 elements
*/



import java.util.*;

public class p9 {

    public static void main(String[] args) {

        System.out.println("=== LinkedHashMap Demonstration ===");

        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>() {

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 4;   // keeps only latest 4 entries
            }
        };

        // Adding elements
        map.put(1, "Apple");
        map.put(2, "Strawberry");
        map.put(3, "Pear");
        map.put(4, "Cucumber");
        map.put(5, "Grapes");

        // Display entries
        System.out.println("\nIterating over entries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nAfter adding 5 elements (eldest removed automatically):");
        System.out.println(map);
    }
}
