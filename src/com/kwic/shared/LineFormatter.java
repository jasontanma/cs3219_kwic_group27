package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 24/8/16.
 * Format the line by setting the first letter of non ignored word to be capitalized while the rest to be lower case.
 */
public class LineFormatter {
    ArrayList<Line> lines;

    public LineFormatter(ArrayList<Line> lines) {
        this.lines = lines;
    }

    /**
     * Format the line.
     * @return  Arraylist of formatted line.
     */
    public ArrayList<Line> format() {
        for(Line line: lines) {
            char capitalizedChar = Character.toUpperCase(line.getChar(0,0));
            line.setChar(0, 0, capitalizedChar);
        }
        return lines;
    }

    public static void main(String[] args) {

        ArrayList<Line> a = new ArrayList<>();
        a.add(new Line(new String[]{"working", "very", "hard"}));
        a.add(new Line(new String[]{"sleep", "all", "day"}));
        a.add(new Line(new String[]{"Today", "after", "tomorrow"}));
        a.add(new Line(new String[]{"Gold", "and", "Silver"}));
        a.add(new Line(new String[]{"a", "an", "the"}));

        IgnoreWordFilterer b = new IgnoreWordFilterer(new CircularShift(a).circulate());
        ArrayList<String> ignoredWords = new ArrayList<>();
        ignoredWords.add("ALL");
        ignoredWords.add("hArd");
        ignoredWords.add("A");
        ignoredWords.add("aN");
        ignoredWords.add("aNd");
        ignoredWords.add("Day");
        ignoredWords.add("the");
//        ArrayList<String> processedIgnoredWords = new LowercaseConvertor(ignoredWords).getLowercaseList();
        ArrayList<String> processedIgnoredWords = ignoredWords;
        ArrayList<Line> c = b.filterIgnoredWordsIgnoreCase(processedIgnoredWords);
        LineFormatter c2 = new LineFormatter(c);
        Alphabetizer d = new Alphabetizer();
        ArrayList<Line> e = d.sort(c2.format());
        for(int i = 0; i < e.size(); ++i) {
            System.out.println(i + " " + e.get(i));
        }
    }
}
