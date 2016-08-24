package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 24/8/16.
 * Set the arraylist of string to all lowercase.
 */
public class LowercaseConvertor {
    public LowercaseConvertor() {}

    /**
     * Convert the arraylist of line object to lowercase.
     * @param   lineList     Arraylist of line object to be lowercased.
     * @return               ArrayList of lowercased string.
     */
    public ArrayList<Line> convertLineListToLowercaseList(ArrayList<Line> stringList) {
        ArrayList<Line> lowercasedStringList = new ArrayList<>();
        for(Line string: stringList) {
            ArrayList<String> strList = convertStringListToLowercaseList(string.getWords());
            Line lowercasedLine = new Line(strList);
            lowercasedStringList.add(lowercasedLine);
        }
        return lowercasedStringList;
    }

    /**
     * Convert the arraylist of string to lowercase.
     * @param stringList     Arraylist of string to be lowercased.
     * @return               ArrayList of lowercased string.
     */
    public ArrayList<String> convertStringListToLowercaseList(ArrayList<String> stringList) {
        ArrayList<String> lowercasedStringList = new ArrayList<>();
        for(String string: stringList) {
            lowercasedStringList.add(string.toLowerCase());
        }
        return lowercasedStringList;
    }
}
