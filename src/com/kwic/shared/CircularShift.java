package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by MA on 2016/08/20.
 * Handles the shifting of word by removing the first word of the line and append it to the end of the line,
 * including the original line.
 */
public class CircularShift {
    private ArrayList<Line> lines;

    public CircularShift(ArrayList<Line> lines) {
        this.lines = lines;
    }

    /**
        Circulate all the lines and get all the rotation of words of each line.
        @return             Arraylist of line object of all rotation of words from each line.
     */
    public ArrayList<Line> circulate() {
        ArrayList<Line> compiledCirculatedLines = new ArrayList<>();

        for(Line line: lines) {
            ArrayList<String> words = line.getWords();
            compiledCirculatedLines.addAll(circulateLine(words));
        }
        return compiledCirculatedLines;
    }

    /**
        Circulate arraylist of words.
        @param  words       Arraylist of words to be circulated.
        @return             Arraylist of line object of all rotation of words from the line.
     */
    private ArrayList<Line> circulateLine(ArrayList<String> words) {
        ArrayList<Line> circulatedLines = new ArrayList<>();
        circulatedLines.add(new Line(new ArrayList<>(words)));
        for(int i = 0; i < words.size() - 1; i++) {
            words.add(words.remove(0));
            circulatedLines.add(new Line(new ArrayList<>(words)));
        }
        return circulatedLines;
    }

    public static void main(String[] args) {
        ArrayList<Line> a = new ArrayList<>();
        a.add(new Line(new String[]{"working", "very", "hard"}));
        a.add(new Line(new String[]{"sleep", "all", "day"}));
        CircularShift b = new CircularShift(a);
        ArrayList<Line> c = b.circulate();
        for(int i = 0; i < c.size(); ++i) {
            System.out.println(i + " " + c.get(i));
        }
    }
}
