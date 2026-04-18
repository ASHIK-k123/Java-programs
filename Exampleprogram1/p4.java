package com.lab1;

/*
p4. Write a java program for getting different colors through ArrayList interface and extract
the elements 1st and 2nd from the ArrayList object by using subList()
*/

import java.util.*;

public class p4 {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        // Adding colors
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        // Display full list
        System.out.println("Full List: " + ls);

        // Extract 1st and 2nd elements using subList (index 0 to 2)
        List<String> subList = ls.subList(0, 2);

        // Display sublist
        System.out.println("First and Second Elements: " + subList);
    }
}
