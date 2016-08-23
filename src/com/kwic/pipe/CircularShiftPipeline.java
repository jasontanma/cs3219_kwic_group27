package com.kwic.pipe;

import com.kwic.adt.CircularShift;
import com.kwic.adt.IgnoreWordFilter;
import com.kwic.shared.Lines;
import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 */
public class CircularShiftPipeline extends CircularShift implements Pipeline {

    private ArrayList<String> ignoredWords;

    public CircularShiftPipeline(ArrayList<Lines> lines, ArrayList<String> ignoredWords) {
        super(lines);
        this.ignoredWords = ignoredWords;
    }

    public void next() {
        ArrayList<Lines> circulatedLines = circulate();
        IgnoreWordFilterPipeline filterPipeline = new IgnoreWordFilterPipeline(circulatedLines, ignoredWords);
        filterPipeline.next();
    }
}
