package com.kwic.pipeandfilter.filter;

import com.kwic.pipeandfilter.pipe.IgnoreWordFiltererPipe;
import com.kwic.shared.IgnoreWordFilterer;
import com.kwic.shared.Line;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 23/8/16.
 * Filter block version of ignore word filter class.
 */
public class IgnoreWordFiltererFilter implements Filter {

    private IgnoreWordFilterer ignoredWordFilterer;
    private ArrayList<String> ignoredWords;
    private ArrayList<Line> filteredLines;

    public IgnoreWordFiltererFilter(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        this.ignoredWordFilterer = new IgnoreWordFilterer(lines);
        this.ignoredWords = ignoredWords;
    }

    public void execute() {
        filteredLines = ignoredWordFilterer.filterIgnoredWordsIgnoreCase(ignoredWords);
        sentToPipe();
    }

    public void sentToPipe() {
        IgnoreWordFiltererPipe ignoreWordFiltererPipe = new IgnoreWordFiltererPipe(filteredLines, ignoredWords);
        ignoreWordFiltererPipe.next();
    }
}
