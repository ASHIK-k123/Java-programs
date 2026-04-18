package com.lab2;

/*
p7. Write a Java program to remove all elements from the TreeMap, verify size is zero,
then add elements again and check size
*/



import java.util.*;

public class p7 {

    public static void main(String[] args) {

        Map<Integer, String> treeMap = new TreeMap<>();

        // Adding elements
        treeMap.put(1, "Apple");
        treeMap.put(2, "Strawberry");
        treeMap.put(3, "Pear");
        treeMap.put(4, "Cucumber");
        treeMap.put(5, "Grapes");

        // Remove all elements
        treeMap.clear();
        System.out.println("After removing all elements size: " + treeMap.size());

        // Add again
        treeMap.put(1, "Apple");
        treeMap.put(2, "Strawberry");
        treeMap.put(3, "Pear");
        treeMap.put(4, "Cucumber");
        treeMap.put(5, "Grapes");

        System.out.println("After adding all elements size: " + treeMap.size());
    }
}
