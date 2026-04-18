package com.lab1;

/*
p7. Write a Java program to iterate a linked list in reverse order
(using objlist.descendingIterator())
*/

import java.util.*;

public class p7 {

    public static void main(String[] args) {

        LinkedList<String> ls = new LinkedList<>();

        // Adding elements
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Reverse Order:");

        // Reverse iteration using descendingIterator
        Iterator<String> iterator = ls.descendingIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
