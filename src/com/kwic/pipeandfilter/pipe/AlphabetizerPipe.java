package com.kwic.pipeandfilter.pipe;

import java.util.ArrayList;

import com.kwic.pipeandfilter.OutputSink;
import com.kwic.shared.Interaction;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 24/8/16.
 */
public class AlphabetizerPipe implements Pipe {

    private ArrayList<Line> sortedLines;

    public AlphabetizerPipe(ArrayList<Line> sortedLines) {
        this.sortedLines = sortedLines;
    }

    public void next() {
        OutputSink outputSink = new OutputSink(sortedLines);
        outputSink.output();
    }
}
