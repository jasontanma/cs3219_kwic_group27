package com.kwic.shared;


import java.util.*;

/**
 * Created by MA on 2016/08/20.
 * Sort the lines by alphabetical order.
 */
public class Alphabetizer {

    public Alphabetizer() {}

    /**
     * Sort the lines by alphabetical order.
     * @return  Arraylist of sorted lines.
     */
    public ArrayList<Line> sort(ArrayList<Line> lines) {
        Collections.sort(lines, new Line.LinesComparator());
        return lines;
    }

    public static void main(String[] args) {
        ArrayList<Line> a = new ArrayList<>();
        a.add(new Line(new String[]{"working", "very", "hard"}));
        a.add(new Line(new String[]{"sleep", "all", "day"}));
        a.add(new Line(new String[]{"Today", "after", "tomorrow"}));
        a.add(new Line(new String[]{"Gold", "and", "Silver"}));
        a.add(new Line(new String[]{"a", "an", "the"}));

        IgnoreWordFilter b = new IgnoreWordFilter(new CircularShift(a).circulate());
        ArrayList<String> ignoredWords = new ArrayList<>();
        ignoredWords.add("all");
        ignoredWords.add("hard");
        ignoredWords.add("a");
        ignoredWords.add("an");
        ignoredWords.add("and");
        ignoredWords.add("Day");
        ignoredWords.add("the");
        ArrayList<Line> c = b.filterIgnoredWordsIgnoreCase(ignoredWords);
        Alphabetizer d = new Alphabetizer();
        ArrayList<Line> e = d.sort(c);
        for(int i = 0; i < e.size(); ++i) {
            System.out.println(i + " " + e.get(i));
        }
    }
}
