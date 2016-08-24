package com.kwic.pipeandfilter.filter;

import com.kwic.pipeandfilter.pipe.AlphabetizerPipe;
import com.kwic.shared.Alphabetizer;
import com.kwic.shared.Line;
import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 * Filter block version of alphabetizer class.
 */
public class AlphabetizerFilter implements Filter {

    ArrayList<Line> lines;
    ArrayList<Line> sortedLines;

    public AlphabetizerFilter(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public void execute() {
        Alphabetizer alphabetizer = new Alphabetizer();
        this.sortedLines = alphabetizer.sort(lines);
        sentToPipe();
    }

    public void sentToPipe() {
        AlphabetizerPipe alphabetizerPipe = new AlphabetizerPipe(sortedLines);
        alphabetizerPipe.next();
    }
}
