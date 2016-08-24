package com.kwic.pipe;

import com.kwic.shared.IgnoreWordFilter;
import com.kwic.shared.Line;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 * Pipeline block version of ignore word filter class.
 */
public class IgnoreWordFilterPipeline extends IgnoreWordFilter implements Pipeline {

    private ArrayList<String> ignoredWords;

    public IgnoreWordFilterPipeline(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        super(lines);
        this.ignoredWords = ignoredWords;
    }

    public void next() {
        AlphabetizerPipeline alphaPipeline = new AlphabetizerPipeline(filterIgnoredWordsIgnoreCase(ignoredWords));
        alphaPipeline.next();
    }
}
