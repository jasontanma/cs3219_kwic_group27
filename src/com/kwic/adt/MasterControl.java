package com.kwic.adt;

import com.kwic.shared.*;

import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
 * Master control for ADT version of KWIC index.
 */
public class MasterControl {

    public static void main(String[] args) {

        Interaction.displayWelcomeMessage();
        ArrayList<Line> lines = Interaction.getLines();
        ArrayList<String> ignoredWords = Interaction.getIgnoredWords();

        CircularShift circularShift = new CircularShift(lines);
        IgnoreWordFilter ignoreWordFilter = new IgnoreWordFilter(circularShift.circulate());
        Alphabetizer alphabetizer = new Alphabetizer(ignoreWordFilter.filterIgnoredWords(ignoredWords));

        Interaction.displayKWICIndex(alphabetizer.sort());
    }
}
