package com.lab1;

/*
p5. Write a java program for getting different colors through ArrayList interface and delete
nth element from the ArrayList object by using remove by index
*/

import java.util.*;

public class p5 {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        // Adding colors
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Original List: " + ls);

        int n = 3; // example: remove 3rd element

        // index = n-1 (because index starts from 0)
        String removedElement = ls.remove(n - 1);

        System.out.println("Removed Element: " + removedElement);
        System.out.println("Updated List: " + ls);
    }
}
