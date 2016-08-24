package com.kwic.pipe;

import com.kwic.shared.Alphabetizer;
import com.kwic.shared.Interaction;
import com.kwic.shared.Line;
import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 * Pipeline block version of alphabetizer class.
 */
public class AlphabetizerPipeline extends Alphabetizer implements Pipeline {

    ArrayList<Line> lines;
    public AlphabetizerPipeline(ArrayList<Line> lines) {
        super();
        this.lines = lines;

    }

    public void next() {
        ArrayList<Line> sortedLines = sort(lines);
        Interaction.displayKWICIndex(sortedLines);
    }
}
