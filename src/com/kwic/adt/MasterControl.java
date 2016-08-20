package com.kwic.adt;

import com.kwic.shared.Input;
import com.kwic.shared.Lines;
import com.kwic.shared.Output;

import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
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

        CircularShift circularShift = new CircularShift(lines);

        IgnoreWordFilter ignoreWordFilter = new IgnoreWordFilter(circularShift.circulate());

        Alphabetizer alphabetizer = new Alphabetizer(ignoreWordFilter.filterIgnoredWords(ignoredWords));

        Output.displayKWICIndex(alphabetizer.sort());


    }

}
