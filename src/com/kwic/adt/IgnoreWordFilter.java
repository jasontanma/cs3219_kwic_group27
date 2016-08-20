package com.kwic.adt;

import com.kwic.shared.Lines;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
/**
 * Created by MA on 2016/08/20.
 */
public class IgnoreWordFilter {
    private CircularShift circularShift;

    public IgnoreWordFilter(CircularShift circularShift) {
        this.circularShift = circularShift;
    }

    public ArrayList<Lines> filterIgnoredWords(ArrayList<String> ignoredWords) {
        ArrayList<Lines> circulatedWords = circularShift.circulate();
        for(int i = 0; i < circulatedWords.size(); ++i) {
            if(ignoredWords.contains(circulatedWords.get(i).getWord(0))) {
                circulatedWords.remove(i);
                --i;
            }
        }
        return circulatedWords;
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
        for(int i = 0; i < c.size(); ++i) {
            System.out.println(i + " " + c.get(i));
        }

    }

}
