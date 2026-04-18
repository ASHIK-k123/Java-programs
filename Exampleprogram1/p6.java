package com.lab1;

/*
p6. Write a Java program to iterate through all elements in a linked list starting at
the specified position (2nd) using iterator
(Hint: Iterator iteratorObj = listObj.listIterator(1))
*/

import java.util.*;

public class p6 {

    public static void main(String[] args) {

        List<String> ls = new LinkedList<>();

        // Adding elements
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        // Start from 2nd position (index 1)
        Iterator<String> iterator = ls.listIterator(1);

        System.out.println("Elements from 2nd position:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
