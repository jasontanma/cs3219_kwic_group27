package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by tanmunaw on 24/8/16.
 * Set the arraylist of string to all lowercase.
 */
public class LowercaseConvertor {
    private ArrayList<String> stringList;

    public LowercaseConvertor(ArrayList<String> stringList) {
        this.stringList = stringList;
    }

    /**
     * Get the lowercased arraylist of string.
     * @return      ArrayList of lowercased string.
     */
    public ArrayList<String> getLowercaseList() {
        ArrayList<String> lowercasedStringList = new ArrayList<>();
        for(String string: stringList) {
            lowercasedStringList.add(string.toLowerCase());
        }
        return lowercasedStringList;
    }
}
