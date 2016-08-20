package com.kwic.adt;


import com.kwic.shared.Lines;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MA on 2016/08/20.
 */
public class Alphabetizer {
    ArrayList<Lines> lines;

    public Alphabetizer(ArrayList<Lines> lines) {
        this.lines = (ArrayList<Lines>) lines.clone();
    }

    public String[] sort() {
        String[] outputStr = new String[lines.size()];
        for(int i = 0; i < lines.size(); ++i) {
            outputStr[i] = lines.get(i).toString();
        }
        Arrays.sort(outputStr);
        return outputStr;
    }


    public static void main(String[] args) {
        ArrayList<Lines> a = new ArrayList<Lines>();
        a.add(new Lines(new String[]{"working", "very", "hard"}));
        a.add(new Lines(new String[]{"sleep", "all", "day"}));
        a.add(new Lines(new String[]{"Today", "after", "tomorrow"}));
        a.add(new Lines(new String[]{"Gold", "and", "Silver"}));
        a.add(new Lines(new String[]{"a", "an", "the"}));

        IgnoreWordFilter b = new IgnoreWordFilter(new CircularShift(a));
        ArrayList<String> ignoredWords = new ArrayList<String>();
        ignoredWords.add("all");
        ignoredWords.add("hard");
        ignoredWords.add("a");
        ignoredWords.add("an");
        ignoredWords.add("and");
        ignoredWords.add("Day");
        ignoredWords.add("the");
        ArrayList<Lines> c = b.filterIgnoredWords(ignoredWords);
        Alphabetizer d = new Alphabetizer(c);
        String[] e = d.sort();
        for(int i = 0; i < e.length; ++i) {
            System.out.println(i + " " + e[i]);
        }

    }


}
