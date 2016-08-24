package com.kwic.pipeandfilter.pipe;

import java.util.ArrayList;

import com.kwic.pipeandfilter.filter.AlphabetizerFilter;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 24/8/16.
 */
public class IgnoreWordFiltererPipe implements Pipe {

    private ArrayList<String> ignoredWords;
    private ArrayList<Line> filteredLines;

    public IgnoreWordFiltererPipe(ArrayList<Line> filteredLines, ArrayList<String> ignoredWords) {
        this.filteredLines = filteredLines;
        this.ignoredWords = ignoredWords;
    }

    public void next() {
        AlphabetizerFilter alphabetizerFilter = new AlphabetizerFilter(filteredLines);
        alphabetizerFilter.execute();
    }
}
