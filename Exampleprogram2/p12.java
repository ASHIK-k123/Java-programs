package com.lab2;

/*
p12. Write a Java program to create a LinkedHashMap using arrays of keys and values
and display the result
*/



import java.util.*;

public class p12 {

    public static void main(String[] args) {

        String[] keys = {"C", "A", "B", "E", "D"};
        Integer[] values = {3, 1, 2, 5, 4};

        Map<String, Integer> lMap = new LinkedHashMap<>();

        // Inserting elements from arrays
        for (int i = 0; i < keys.length; i++) {
            lMap.put(keys[i], values[i]);
        }

        // Display using traversal (recommended)
        System.out.println("LinkedHashMap contents:");

        for (Map.Entry<String, Integer> entry : lMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
