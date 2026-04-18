package com.lab1;

/*
p2. Write a java program for getting different colors through ArrayList interface and remove
the 2nd element and color "Blue" from the ArrayList (using remove by index and remove by object)
*/

import java.util.*;

public class p1 {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        // Adding colors
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        // Original list
        System.out.println("Original List: " + ls);

        // Remove 2nd element (index 1)
        ls.remove(1);
        System.out.println("After removing 2nd element: " + ls);

        // Remove "Blue" by object
        ls.remove("Blue");
        System.out.println("After removing Blue: " + ls);
    }
}

