package com.kwic.adt;

import com.kwic.shared.Lines;

import java.util.ArrayList;
/**
 * Created by MA on 2016/08/20.
 */
public class IgnoreWordFilter {
    private ArrayList<Lines> circulatedLines;

    public IgnoreWordFilter(ArrayList<Lines> circulatedLines) {
        this.circulatedLines = circulatedLines;
    }

    public ArrayList<Lines> filterIgnoredWords(ArrayList<String> ignoredWords) {
        ArrayList<Lines> filteredLines = new ArrayList<Lines>();
        for(int i = 0; i < circulatedLines.size(); ++i) {
            if(!ignoredWords.contains(circulatedLines.get(i).getWord(0))) {
                filteredLines.add(circulatedLines.get(i).copy());
            }
        }
        return filteredLines;
    }


    public static void main(String[] args) {
        ArrayList<Lines> a = new ArrayList<Lines>();
        a.add(new Lines(new String[]{"working", "very", "hard"}));
        a.add(new Lines(new String[]{"sleep", "all", "day"}));
        a.add(new Lines(new String[]{"Today", "after", "tomorrow"}));
        a.add(new Lines(new String[]{"Gold", "and", "Silver"}));
        a.add(new Lines(new String[]{"a", "an", "the"}));

        IgnoreWordFilter b = new IgnoreWordFilter(new CircularShift(a).circulate());
        ArrayList<String> ignoredWords = new ArrayList<String>();
        ignoredWords.add("all");
        ignoredWords.add("hard");
        ignoredWords.add("a");
        ignoredWords.add("an");
        ignoredWords.add("and");
        ignoredWords.add("Day");
        ignoredWords.add("the");
        ArrayList<Lines> c = b.filterIgnoredWords(ignoredWords);
        for(int i = 0; i < c.size(); ++i) {
            System.out.println(i + " " + c.get(i));
        }

    }

}
