package com.kwic.shared;

import java.util.ArrayList;
/**
 * Created by MA on 2016/08/20.
 * Filter out the line with starting word that is included in the ignored words.
 */
public class IgnoreWordFilterer {
    private ArrayList<Line> circulatedLines;

    public IgnoreWordFilterer(ArrayList<Line> circulatedLines) {
        this.circulatedLines = circulatedLines;
    }

    /**
     Filter the lines starting with ignored words.
     @param     ignoredWords    Arraylist of words to be ignored
     @return             Arraylist of line object after getting filtered out by ignored words.
     */
    public ArrayList<Line> filterIgnoredWordsIgnoreCase(ArrayList<String> ignoredWords) {
        ArrayList<Line> filteredLines = new ArrayList<>();
        for(Line line: circulatedLines) {
            if(!ignoredWords.contains(line.getWord(0).toLowerCase())) {
                filteredLines.add(line.copy());
            }
        }
        return filteredLines;
    }
}
