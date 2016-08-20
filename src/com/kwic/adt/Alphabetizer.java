package com.kwic.adt;


import com.kwic.shared.Lines;

import java.util.*;

/**
 * Created by MA on 2016/08/20.
 */
public class Alphabetizer {
    private ArrayList<Lines> lines;

    public Alphabetizer(ArrayList<Lines> lines) {
        this.lines = (ArrayList<Lines>) lines.clone();
    }

    public ArrayList<String> sort() {
        Collections.sort(lines, new Lines.LinesComparator());
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(Lines line : lines) {
            stringArrayList.add(line.toString());
        }

        return stringArrayList;
    }

    public static void main(String[] args) {
        ArrayList<Lines> a = new ArrayList<>();
        a.add(new Lines(new String[]{"working", "very", "hard"}));
         a.add(new Lines(new String[]{"sleep", "all", "day"}));
        a.add(new Lines(new String[]{"Today", "after", "tomorrow"}));
        a.add(new Lines(new String[]{"Gold", "and", "Silver"}));
        a.add(new Lines(new String[]{"a", "an", "the"}));

        IgnoreWordFilter b = new IgnoreWordFilter(new CircularShift(a).circulate());
        ArrayList<String> ignoredWords = new ArrayList<>();
        ignoredWords.add("all");
        ignoredWords.add("hard");
        ignoredWords.add("a");
        ignoredWords.add("an");
        ignoredWords.add("and");
        ignoredWords.add("Day");
        ignoredWords.add("the");
        ArrayList<Lines> c = b.filterIgnoredWords(ignoredWords);
        Alphabetizer d = new Alphabetizer(c);
        ArrayList<String> e = d.sort();
        for(int i = 0; i < e.size(); ++i) {
            System.out.println(i + " " + e.get(i));
        }

    }


}
