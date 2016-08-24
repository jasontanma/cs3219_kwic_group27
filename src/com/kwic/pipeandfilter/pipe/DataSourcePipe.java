package com.kwic.pipeandfilter.pipe;

import com.kwic.pipeandfilter.filter.CircularShiftFilter;

import java.util.ArrayList;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 24/8/16.
 */
public class DataSourcePipe implements Pipe {
    ArrayList<Line> lines;
    ArrayList<String> ignoredWords;

    public DataSourcePipe(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        this.lines = lines;
        this.ignoredWords = ignoredWords;
    }

    public void next() {
        CircularShiftFilter circularShiftFilter = new CircularShiftFilter(lines, ignoredWords);
        circularShiftFilter.execute();
    }
}
