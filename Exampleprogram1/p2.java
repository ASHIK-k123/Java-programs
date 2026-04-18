package com.lab1;

/*
p1. Write a java program for getting different colors through ArrayList interface and search
whether the color "Red" is available or not.
(Hint: Use ArrayListObj.contains())
*/

import java.util.*;

public class p2 {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        // Adding colors
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        // Display list
        System.out.println("Color List: " + ls);

        // Check if "Red" is present
        if (ls.contains("Red")) {
            System.out.println("Red is available in the list");
        } else {
            System.out.println("Red is NOT available in the list");
        }
    }
}
