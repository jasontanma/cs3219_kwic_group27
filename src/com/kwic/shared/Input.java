package com.kwic.shared;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kylel on 20/8/2016.
 */
public class Input {

    private static final String EMPTY_STRING = "";

    public static ArrayList<String> getInput(int size) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        String inputLine;

        while(input.size() < size && sc.hasNextLine()) {
            inputLine = sc.nextLine();
            if(inputLine.equals(EMPTY_STRING) || inputLine.trim().length() == 0) {
                break;
            } else {
                input.add(inputLine.trim());
            }
        }

        return input;
    }
}
