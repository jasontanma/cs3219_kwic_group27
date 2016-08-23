package com.kwic.pipe;

import com.kwic.shared.CircularShift;
import com.kwic.shared.Line;
import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 */
public class CircularShiftPipeline extends CircularShift implements Pipeline {

    private ArrayList<String> ignoredWords;

    public CircularShiftPipeline(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        super(lines);
        this.ignoredWords = ignoredWords;
    }

    public void next() {
        ArrayList<Line> circulatedLines = circulate();
        IgnoreWordFilterPipeline filterPipeline = new IgnoreWordFilterPipeline(circulatedLines, ignoredWords);
        filterPipeline.next();
    }
}
