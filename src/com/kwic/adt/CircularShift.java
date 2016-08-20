package com.kwic.adt;

import java.util.ArrayList;
import com.kwic.shared.Lines;

/**
 * Created by MA on 2016/08/20.
 */
public class CircularShift {
    private ArrayList<Lines> lines;


    public CircularShift(ArrayList<Lines> lines) {
        this.lines = lines;
    }

    public ArrayList<Lines> circulate() {
        ArrayList<Lines> circulatedLines = new ArrayList<Lines>();
        for(int i = 0; i < lines.size(); ++i) {
            Lines line = lines.get(i);
            ArrayList<String> words = line.getWords();
            circulatedLines.add(new Lines((ArrayList<String>)words.clone()));
            for(int j = 0; j < words.size() - 1; ++j) {
                words.add(words.remove(0));
                circulatedLines.add(new Lines((ArrayList<String>)words.clone()));
            }
        }
        return circulatedLines;
    }

    public static void main(String[] args) {
        ArrayList<Lines> a = new ArrayList<Lines>();
        a.add(new Lines(new String[]{"working", "very", "hard"}));
        a.add(new Lines(new String[]{"sleep", "all", "day"}));
        CircularShift b = new CircularShift(a);
        ArrayList<Lines> c = b.circulate();
        for(int i = 0; i < c.size(); ++i) {
            System.out.println(i + " " + c.get(i));
        }

    }
}
