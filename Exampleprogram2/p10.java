package com.lab2;

/*
p10. Write a Java program to store programming languages and their years
using LinkedHashMap and display them
*/



import java.util.*;

public class p10 {

    public static void main(String[] args) {

        Map<String, Integer> programmingLanguages = new LinkedHashMap<>();

        programmingLanguages.put("Java", 1995);
        programmingLanguages.put("Python", 1991);
        programmingLanguages.put("JavaScript", 1995);
        programmingLanguages.put("C++", 1985);

        // Display using traversal (recommended in exams)
        for (Map.Entry<String, Integer> entry : programmingLanguages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
