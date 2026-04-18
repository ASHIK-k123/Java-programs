package com.lab2;

/*
p2. Remove all elements from the HashMap, then verify that its size is zero and
include once again following elements and check its size
*/


import java.util.HashMap;
import java.util.Map;

public class p2 {

    public static void main(String[] args) {

        Map<Integer, String> hashMap = new HashMap<>();

        // Adding elements
        hashMap.put(1, "Apple");
        hashMap.put(2, "Strawberry");
        hashMap.put(3, "Pear");
        hashMap.put(4, "Cucumber");
        hashMap.put(5, "Grapes");

        System.out.println("Initial size: " + hashMap.size());

        // Remove all elements
        hashMap.clear();
        System.out.println("After removing all elements size: " + hashMap.size());

        // Add elements again
        hashMap.put(1, "Apple");
        hashMap.put(2, "Strawberry");
        hashMap.put(3, "Pear");
        hashMap.put(4, "Cucumber");
        hashMap.put(5, "Grapes");

        System.out.println("After adding all elements size: " + hashMap.size());
    }
}
