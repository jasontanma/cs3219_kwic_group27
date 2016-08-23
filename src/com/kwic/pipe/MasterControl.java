package com.kwic.pipe;

import java.util.ArrayList;
import com.kwic.shared.Lines;
import com.kwic.shared.Input;

/**
 * Created by tanmunaw on 23/8/16.
 */
public class MasterControl {
    public static void main(String[] args) {

        Input.displayWelcomeMessage();

        ArrayList<ArrayList<String>> inputString = Input.getLines();

        ArrayList<Lines> lines = new ArrayList<>();
        for(ArrayList<String> inputWords : inputString) {
            lines.add(new Lines(inputWords));
        }

        ArrayList<String> ignoredWords = Input.getIgnoredWords();

        CircularShiftPipeline circularShift = new CircularShiftPipeline(lines, ignoredWords);
        circularShift.next();

//        IgnoreWordFilter ignoreWordFilter = new IgnoreWordFilter(circularShift.circulate());
//
//        Alphabetizer alphabetizer = new Alphabetizer(ignoreWordFilter.filterIgnoredWords(ignoredWords));
//
//        Output.displayKWICIndex(alphabetizer.sort());


    }
}
