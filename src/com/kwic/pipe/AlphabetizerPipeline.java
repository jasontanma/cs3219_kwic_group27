package com.kwic.pipe;

import com.kwic.adt.Alphabetizer;
import com.kwic.shared.Lines;
import java.util.ArrayList;

import com.kwic.shared.Output;

/**
 * Created by tanmunaw on 23/8/16.
 */
public class AlphabetizerPipeline extends Alphabetizer implements Pipeline {


    public AlphabetizerPipeline(ArrayList<Lines> lines) {
        super(lines);
    }

    public void next() {
        Output.displayKWICIndex(sort());
    }
}
