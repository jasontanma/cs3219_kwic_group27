package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
 */
public class Output {

    public static void main(String[] args) {
        ArrayList<String> kwicIndex = new ArrayList<>();
        kwicIndex.add("Fake one la");
        kwicIndex.add("I also fake rofl");
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayArrayList(ArrayList<String> list) {
        list.forEach(System.out::println);
    }
}