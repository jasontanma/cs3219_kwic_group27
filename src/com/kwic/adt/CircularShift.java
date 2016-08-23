package com.kwic.adt;

import java.util.ArrayList;
import com.kwic.shared.Line;

/**
 * Created by MA on 2016/08/20.
 */
public class CircularShift {
    private ArrayList<Line> lines;

    public CircularShift(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Line> circulate() {
        ArrayList<Line> circulatedLines = new ArrayList<Line>();
        for(int i = 0; i < lines.size(); ++i) {
            Line line = lines.get(i);
            ArrayList<String> words = line.getWords();
            circulatedLines.add(new Line((ArrayList<String>)words.clone()));
            for(int j = 0; j < words.size() - 1; ++j) {
                words.add(words.remove(0));
                circulatedLines.add(new Line((ArrayList<String>)words.clone()));
            }
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
