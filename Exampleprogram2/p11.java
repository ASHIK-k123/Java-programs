package com.lab2;

/*
p11. Write a Java program to store programming languages and their release years
using LinkedHashMap and display them in insertion order
*/



import java.util.LinkedHashMap;
import java.util.Map;

public class p11 {

    public static void main(String[] args) {

        Map<String, Integer> programmingLanguages = new LinkedHashMap<>();

        programmingLanguages.put("Java", 1995);
        programmingLanguages.put("Python", 1991);
        programmingLanguages.put("JavaScript", 1995);
        programmingLanguages.put("C++", 1985);

        // Display entries
        for (Map.Entry<String, Integer> entry : programmingLanguages.entrySet()) {
            System.out.println(entry.getKey() + " was developed in " + entry.getValue());
        }
    }
}
