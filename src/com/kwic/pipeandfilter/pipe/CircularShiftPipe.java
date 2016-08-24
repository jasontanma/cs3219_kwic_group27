package com.kwic.pipeandfilter.pipe;

import com.kwic.pipeandfilter.filter.IgnoreWordFiltererFilter;
import com.kwic.shared.Line;
import java.util.ArrayList;

/**
 * Created by tanmunaw on 24/8/16.
 */
public class CircularShiftPipe implements Pipe {

    private ArrayList<String> ignoredWords;
    private ArrayList<Line> circulatedLines;

    public CircularShiftPipe(ArrayList<Line> circulatedLines, ArrayList<String> ignoredWords) {
        this.circulatedLines = circulatedLines;
        this.ignoredWords = ignoredWords;
    }

    public void next() {
        IgnoreWordFiltererFilter ignoreWordFiltererFilter = new IgnoreWordFiltererFilter(circulatedLines, ignoredWords);
        ignoreWordFiltererFilter.execute();
    }
}
