package com.kwic.pipeandfilter;

import com.kwic.shared.Interaction;

import java.util.ArrayList;
import com.kwic.shared.Line;
import com.kwic.shared.LineFormatter;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;

/**
 * Created by tanmunaw on 24/8/16.
 */
public class OutputSink {
    ArrayList<Line> sortedLines;

    public OutputSink(ArrayList<Line> sortedLines) {
        this.sortedLines = sortedLines;
    }

    public void output() {
        LineFormatter lineFormatter = new LineFormatter(sortedLines);
        ArrayList<Line> formattedLines = lineFormatter.format();
        Interaction.displayKWICIndex(formattedLines);
    }
}
