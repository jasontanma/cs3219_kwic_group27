package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 24/8/16.
 * Format the line by setting the first letter of non ignored word to be capitalized while the rest to be lower case.
 */
public class LineFormatter {
    ArrayList<Line> lines;
    ArrayList<String> ignoredWords;

    public LineFormatter(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        this.lines = lines;
        this.ignoredWords = ignoredWords;
    }

    /**
     * Format the line.
     * @return  Arraylist of formatted line.
     */
    public ArrayList<Line> format() {
        ArrayList<Line> formattedLines = new ArrayList<>();
        for(Line line: lines) {
            ArrayList<String> strLine = new ArrayList<>();
            for(String word: line.getWords()) {
                if(ignoredWords.contains(word)) {
                    strLine.add(word.toLowerCase());
                } else {
                    strLine.add(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
                }
            }
            formattedLines.add(new Line(strLine));
        }
        return formattedLines;
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
        ignoredWords.add("ALL");
        ignoredWords.add("hArd");
        ignoredWords.add("A");
        ignoredWords.add("aN");
        ignoredWords.add("aNd");
        ignoredWords.add("Day");
        ignoredWords.add("the");
//        ArrayList<String> processedIgnoredWords = new LowercaseConvertor(ignoredWords).getLowercaseList();
//        ArrayList<String> processedIgnoredWords = ignoredWords;
        ArrayList<Line> c = b.filterIgnoredWords(processedIgnoredWords);
        LineFormatter c2 = new LineFormatter(c, processedIgnoredWords);
        Alphabetizer d = new Alphabetizer(c2.format());
        ArrayList<String> e = d.sort();
        for(int i = 0; i < e.size(); ++i) {
            System.out.println(i + " " + e.get(i));
        }
    }
}
