package com.lab1;

/*
p9. Write a Java program to display elements and their positions in a linked list
(using l_listobj.get(p))
*/

import java.util.*;

public class p9 {

    public static void main(String[] args) {

        LinkedList<String> ls = new LinkedList<>();

        // Adding elements
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        // Display elements with positions
        System.out.println("Elements with positions:");

        for (int p = 0; p < ls.size(); p++) {
            System.out.println("Position: " + p + " Value: " + ls.get(p));
        }
    }
}
