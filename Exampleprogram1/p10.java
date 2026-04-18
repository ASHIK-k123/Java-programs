package com.lab1;

/*
p10. Write a Java program that swaps two elements (first and third elements) in a linked list
(using Collections.swap(l_list, 0, 2))
*/

import java.util.*;

public class p10 {

    public static void main(String[] args) {

        LinkedList<String> ls = new LinkedList<>();

        // Adding elements
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Before Swapping:");
        System.out.println(ls);

        // Swap first (0) and third (2) elements
        Collections.swap(ls, 0, 2);

        System.out.println("After Swapping:");
        System.out.println(ls);
    }
}
