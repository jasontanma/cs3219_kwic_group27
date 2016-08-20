package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
 */
public class Output {

    private static final String OUTPUT_DISPLAY_MESSAGE = "Generated KWIC index:";

    public static void main(String[] args) {
        ArrayList<String> kwicIndex = new ArrayList<>();
        kwicIndex.add("Fake one la");
        kwicIndex.add("I also fake rofl");

        displayKWICIndex(kwicIndex);
    }

    public static void displayKWICIndex(ArrayList<String> list) {
        System.out.println(OUTPUT_DISPLAY_MESSAGE);
        displayArrayList(list);
    }

    private static void displayArrayList(ArrayList<String> list) {
        list.forEach(System.out::println);
    }
}
