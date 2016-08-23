package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by MA on 2016/08/20.
 */
public class CircularShift {
    private ArrayList<Line> lines;

    public CircularShift(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Line> circulate() {
        ArrayList<Line> compiledCirculatedLines = new ArrayList<>();

        for(Line line: lines) {
            ArrayList<String> words = line.getWords();
            compiledCirculatedLines.addAll(circulateLine(words));
        }
        return compiledCirculatedLines;
    }

    private ArrayList<Line> circulateLine(ArrayList<String> words) {
        ArrayList<Line> circulatedLines = new ArrayList<>();
        circulatedLines.add(new Line(new ArrayList<>(words)));
        for(String ignored : words) {
            words.add(words.remove(0));
            circulatedLines.add(new Line(new ArrayList<>(words)));
        }
        return circulatedLines;
    }

    public static void main(String[] args) {
        ArrayList<Line> a = new ArrayList<Line>();
        a.add(new Line(new String[]{"working", "very", "hard"}));
        a.add(new Line(new String[]{"sleep", "all", "day"}));
        CircularShift b = new CircularShift(a);
        ArrayList<Line> c = b.circulate();
        for(int i = 0; i < c.size(); ++i) {
            System.out.println(i + " " + c.get(i));
        }
    }
}
