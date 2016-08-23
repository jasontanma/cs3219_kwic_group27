package com.kwic.adt;

import com.kwic.shared.Interaction;
import com.kwic.shared.Line;

import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
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
