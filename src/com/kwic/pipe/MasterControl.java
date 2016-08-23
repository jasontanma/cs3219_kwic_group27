package com.kwic.pipe;

import java.util.ArrayList;

import com.kwic.adt.Alphabetizer;
import com.kwic.adt.CircularShift;
import com.kwic.adt.IgnoreWordFilter;
import com.kwic.shared.Interaction;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 23/8/16.
 */
public class MasterControl {
    public static void main(String[] args) {

        Interaction.displayWelcomeMessage();

        ArrayList<Line> lines = Interaction.getLines();

        ArrayList<String> ignoredWords = Interaction.getIgnoredWords();

        CircularShiftPipeline circularShift = new CircularShiftPipeline(lines, ignoredWords);
        circularShift.next();


    }
}
