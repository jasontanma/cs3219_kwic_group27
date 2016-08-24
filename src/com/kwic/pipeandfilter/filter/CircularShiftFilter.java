package com.kwic.pipeandfilter.filter;

import com.kwic.pipeandfilter.pipe.CircularShiftPipe;
import com.kwic.shared.CircularShift;
import com.kwic.shared.Line;
import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 * Filter block version of circular shift class.
 */
public class CircularShiftFilter implements Filter {

    private ArrayList<Line> circulatedLines;
    private ArrayList<Line> lines;
    private ArrayList<String> ignoredWords;

    public CircularShiftFilter(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        this.ignoredWords = ignoredWords;
        this.lines = lines;
    }

    public void execute() {
        CircularShift circularShift = new CircularShift(lines);
        this.circulatedLines = circularShift.circulate();
        sentToPipe();
    }

    public void sentToPipe() {
        CircularShiftPipe circularShiftPipe = new CircularShiftPipe(circulatedLines, ignoredWords);
        circularShiftPipe.next();
    }
}
