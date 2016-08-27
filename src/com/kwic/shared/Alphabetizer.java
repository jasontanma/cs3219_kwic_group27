package com.kwic.shared;


import java.util.*;

/**
 * Created by MA on 2016/08/20.
 * Sort the lines by alphabetical order.
 */
public class Alphabetizer {

    public Alphabetizer() {}

    /**
     * Sort the lines by alphabetical order.
     * @return  Arraylist of sorted lines.
     */
    public ArrayList<Line> sort(ArrayList<Line> lines) {
        Collections.sort(lines, new Line.LinesComparator());
        return lines;
    }
}
