package com.kwic.pipeandfilter;

import com.kwic.pipeandfilter.pipe.DataSourcePipe;
import java.util.ArrayList;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 24/8/16.
 */
public class DataSource {

    ArrayList<Line> lines;
    ArrayList<String> ignoredWords;

    public DataSource(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        this.lines = lines;
        this.ignoredWords = ignoredWords;
    }

    public void execute() {
        DataSourcePipe dataSourcePipe = new DataSourcePipe(lines, ignoredWords);
        dataSourcePipe.next();
    }
}
