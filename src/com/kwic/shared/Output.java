package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
 * Output message on standard output io.
 */
public class Output {

    public static void main(String[] args) {
        ArrayList<String> kwicIndex = new ArrayList<>();
        kwicIndex.add("Fake one la");
        kwicIndex.add("I also fake rofl");
    }

    /**
     * Display single line message on standard output io.
     * @param message   String of message to be displayed.
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Display multiple line messages on standard output io.
     * @param list   List of string of messages to be displayed.
     */
    public static void displayArrayList(ArrayList<Line> list) {
        list.forEach(System.out::println);
    }
}