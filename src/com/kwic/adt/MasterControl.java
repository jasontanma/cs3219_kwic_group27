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
        Interaction.getInputMethod();
        ArrayList<Line> lines = Interaction.getLines();
        ArrayList<String> ignoredWords = Interaction.getIgnoredWords();
        Interaction.getOutputMethod();

        CircularShift circularShift = new CircularShift(lines);
        IgnoreWordFilterer ignoreWordFilter = new IgnoreWordFilterer(circularShift.circulate());
        ArrayList<Line> filteredLine = ignoreWordFilter.filterIgnoredWordsIgnoreCase(ignoredWords);
        ArrayList<Line> capitalizedFilteredLine = Line.capitalizeLines(filteredLine);
        Alphabetizer alphabetizer = new Alphabetizer();

        Interaction.outputKWICIndex(alphabetizer.sort(capitalizedFilteredLine));
    }
}
