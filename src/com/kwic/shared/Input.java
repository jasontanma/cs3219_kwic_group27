package com.kwic.shared;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kylel on 20/8/2016.
 * Read input from IO.
 */
public class Input {

    private static final String EMPTY_STRING = "";

    /**
     * Retrieve the input from standard io.
     * @param size      Number of lines to be read.
     * @param sc        Scanner for reading of data.
     *
     * @return          Arraylist of string input read from standard io.
     */
    public static ArrayList<String> getInput(int size, Scanner sc) {
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

    /**
     * Retrieve the input method from standard io.
     *
     * @return          Arraylist of string input read from standard io.
     */
    public static int getInputMethod() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            return KwicConstant.INVALID_INPUT_METHOD;
        }
    }

    /**
     * Retrieve the file name from standard io.
     *
     * @return          Arraylist of string input read from standard io.
     */
    public static String getFileName() {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        return fileName;
    }
}