package com.kwic.pipeandfilter;

import com.kwic.shared.Interaction;

import java.util.ArrayList;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 24/8/16.
 * Output sink before sending to output.
 */
public class OutputSink {
    ArrayList<Line> sortedLines;

    public OutputSink(ArrayList<Line> sortedLines) {
        this.sortedLines = sortedLines;
    }

    public void output() {
        ArrayList<Line> capitalizedLines = Line.capitalizeLines(sortedLines);
        Interaction.displayKWICIndex(capitalizedLines);
    }
}
