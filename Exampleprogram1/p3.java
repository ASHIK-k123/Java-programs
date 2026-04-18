package com.lab1;

/*
p3. Write a java program for getting different colors through ArrayList interface and sort
them using Collections.sort(ArrayListObj)
*/

import java.util.*;

public class p3 {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        // Adding colors
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        // Before sorting
        System.out.println("Before Sorting: " + ls);

        // Sorting the list
        Collections.sort(ls);

        // After sorting
        System.out.println("After Sorting: " + ls);
    }
}
