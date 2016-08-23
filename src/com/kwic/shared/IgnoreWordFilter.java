package com.kwic.shared;

import java.util.ArrayList;
/**
 * Created by MA on 2016/08/20.
 */
public class IgnoreWordFilter {
    private ArrayList<Line> circulatedLines;

    public IgnoreWordFilter(ArrayList<Line> circulatedLines) {
        this.circulatedLines = circulatedLines;
    }

    public ArrayList<Line> filterIgnoredWords(ArrayList<String> ignoredWords) {
        ArrayList<Line> filteredLines = new ArrayList<>();
        for(Line line: circulatedLines) {
            if(!ignoredWords.contains(line.getWord(0))) {
                filteredLines.add(line.copy());
            }
        }
        return filteredLines;
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
        ArrayList<Line> c = b.filterIgnoredWords(ignoredWords);
        for(int i = 0; i < c.size(); ++i) {
            System.out.println(i + " " + c.get(i));
        }
    }
}