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

        CircularShift circularShift = new CircularShift(lines);

        IgnoreWordFilter ignoreWordFilter = new IgnoreWordFilter(circularShift.circulate());

        LowercaseConvertor lowercaseConvertor = new LowercaseConvertor();
        ArrayList<String> lowercasedIgnoredWords = lowercaseConvertor.convertStringListToLowercaseList(ignoredWords);
        ArrayList<Line> filteredLine = ignoreWordFilter.filterIgnoredWordsIgnoreCase(lowercasedIgnoredWords);

        LineFormatter lineFormatter = new LineFormatter(filteredLine);

        ArrayList<Line> formattedFilteredLine = lineFormatter.format();
        Alphabetizer alphabetizer = new Alphabetizer();

        Interaction.displayKWICIndex(alphabetizer.sort(formattedFilteredLine));
    }

}
