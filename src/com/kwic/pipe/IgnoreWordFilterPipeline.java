package com.kwic.pipe;

import com.kwic.adt.IgnoreWordFilter;
import com.kwic.shared.Lines;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 */
public class IgnoreWordFilterPipeline extends IgnoreWordFilter implements Pipeline {

    private ArrayList<String> ignoredWords;

    public IgnoreWordFilterPipeline(ArrayList<Lines> lines, ArrayList<String> ignoredWords) {
        super(lines);
        this.ignoredWords = ignoredWords;
    }

    public void next() {
//        System.out.println("Filter done");
        AlphabetizerPipeline alphaPipeline = new AlphabetizerPipeline(filterIgnoredWords(ignoredWords));
        alphaPipeline.next();
    }
}
