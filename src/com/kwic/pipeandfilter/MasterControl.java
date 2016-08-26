package com.kwic.pipeandfilter;

import java.util.ArrayList;

import com.kwic.pipeandfilter.filter.CircularShiftFilter;
import com.kwic.pipeandfilter.pipe.DataSourcePipe;
import com.kwic.shared.Interaction;
import com.kwic.shared.Line;

/**
 * Created by tanmunaw on 23/8/16.
 * Master control for pipeline version of KWIC index.
 */
public class MasterControl {

    private ArrayList<Line> lines;
    private ArrayList<String> ignoredWords;

    public static void main(String[] args) {
        MasterControl masterControl = new MasterControl();
        masterControl.run();
    }

    public MasterControl() {}

    public void run() {
        Interaction.displayWelcomeMessage();
        fetchInput();
        passToDataSource(lines, ignoredWords);
    }

    /**
     * Pass input data to data source
     * @param lines         Arraylist of Input Lines
     * @param ignoredWords  Arraylist of ignored words string
     */
    public void passToDataSource(ArrayList<Line> lines, ArrayList<String> ignoredWords) {
        DataSource dataSource = new DataSource(lines, ignoredWords);
        dataSource.execute();
    }

    /**
     * Get input data
     */
    private void fetchInput() {

        Interaction.getInputMethod();
        lines = Interaction.getLines();
        ignoredWords = Interaction.getIgnoredWords();
    }

}
