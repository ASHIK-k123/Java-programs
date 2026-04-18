package com.lab2;

/*
p1. Write a Java program to traverse / iterate all the keys with the specified value in a HashMap
(1,"Apple"), (2,"Strawberry"), (3,"Pear"), (4,"Cucumber"), (5,"Grapes")
*/


import java.util.*;

public class p1 {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Apple");
        hashMap.put(2, "Strawberry");
        hashMap.put(3, "Pear");
        hashMap.put(4, "Cucumber");
        hashMap.put(5, "Grapes");

        // Specified value to search
        String searchValue = "Pear";

        System.out.println("Keys with value '" + searchValue + "':");

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {

            if (entry.getValue().equals(searchValue)) {
                System.out.println("Key: " + entry.getKey());
            }
        }
    }
}
