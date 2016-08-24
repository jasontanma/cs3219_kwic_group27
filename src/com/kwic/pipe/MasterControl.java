package com.kwic.pipe;

import java.util.ArrayList;

import com.kwic.shared.Interaction;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 23/8/16.
 * Master control for pipeline version of KWIC index.
 */
public class MasterControl {
    public static void main(String[] args) {
        Interaction.displayWelcomeMessage();
        Interaction.getInputMethod();
        ArrayList<Line> lines = Interaction.getLines();
        ArrayList<String> ignoredWords = Interaction.getIgnoredWords();

        CircularShiftPipeline circularShift = new CircularShiftPipeline(lines, ignoredWords);
        circularShift.next();
    }
}
