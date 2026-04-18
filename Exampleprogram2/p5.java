package com.lab2;

/*
p5. Write a Java program to traverse / iterate all the keys with the specified value in a TreeMap
(1,"Apple"), (2,"Strawberry"), (3,"Pear"), (4,"Cucumber"), (5,"Grapes")
*/



import java.util.*;
import java.util.Map.Entry;

public class p5 {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "Apple");
        treeMap.put(2, "Strawberry");
        treeMap.put(3, "Pear");
        treeMap.put(4, "Cucumber");
        treeMap.put(5, "Grapes");

        // Specified value to search
        String searchValue = "Apple";

        System.out.println("Keys with value '" + searchValue + "':");

        for (Entry<Integer, String> entry : treeMap.entrySet()) {

            if (entry.getValue().equals(searchValue)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
