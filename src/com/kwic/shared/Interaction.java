package com.kwic.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.kwic.shared.KwicConstant.*;

/**
 * Created by kylel on 23/8/2016.
 * Handles the interaction of ui between system and user, in particular the input and output.
 */
public class Interaction {

    private static final String SPACE_REGEX = "\\s+";

    private static int inputMethod;

    public static void main(String[] args) {
        getLines();
        getIgnoredWords();
    }

    /**
     * Display welcome message when user starts the application.
     */
    public static void displayWelcomeMessage() {
        Output.displayMessage(WELCOME_MESSAGE);
    }

    /**
     * Display welcome message when user starts the application.
     */
    public static void getInputMethod() {
        Output.displayMessage(INPUT_METHOD_MESSAGE);
        int userInput = Input.getInputMethod();
        while(userInput != KwicConstant.MANUAL_INPUT && userInput != KwicConstant.FILE_INPUT) {
            Output.displayMessage(INVALID_INPUT_METHOD_MESSAGE);
            userInput = Input.getInputMethod();
        }
        inputMethod = userInput;
    }

    /**
     * Request the user to enter the lines.
     */
    public static ArrayList<Line> getLines() {
        Scanner sc = new Scanner(System.in);
        if(inputMethod == KwicConstant.MANUAL_INPUT) {
            Output.displayMessage(INPUT_LINES_MESSAGE);
        } else if(inputMethod == KwicConstant.FILE_INPUT) {
            Output.displayMessage(INPUT_LINES_FILE_NAME_MESSAGE);

            String fileName = Input.getFileName();
            File file = new File(fileName);

            while(!file.exists() || file.isDirectory()) {
                Output.displayMessage(INVALID_FILE_NAME_MESSAGE);
                fileName = Input.getFileName();
                file = new File(fileName);
            }

            try {
                sc = new Scanner(new FileInputStream(fileName));
            } catch (FileNotFoundException e) {
            }
        }
        return getInputLines(sc);
    }

    /**
     * Request the user to enter the ignored words.
     */
    public static ArrayList<String> getIgnoredWords() {
        Scanner sc = new Scanner(System.in);
        if(inputMethod == KwicConstant.MANUAL_INPUT) {
            Output.displayMessage(INPUT_IGNORED_WORDS);
        } else if(inputMethod == KwicConstant.FILE_INPUT) {
            Output.displayMessage(INPUT_IGNORE_FILE_NAME_MESSAGE);
            String fileName = Input.getFileName();
            try {
                sc = new Scanner(new FileInputStream(fileName));
            } catch (FileNotFoundException e) {
                Output.displayMessage(INVALID_FILE_NAME_MESSAGE);
                getLines();
            }
        }


        return Input.getInput(IGNORE_LIMIT, sc);
    }

    /**
     * Display the KWIC index on output.
     */
    public static void displayKWICIndex(ArrayList<Line> list) {
        Output.displayMessage(OUTPUT_DISPLAY_MESSAGE);
        Output.displayArrayList(list);
    }

    /**
     * Get input lines from user and process them into arraylist of line.
     * @return      Arraylist of line object that store the input.
     */
    private static ArrayList<Line> getInputLines(Scanner sc) {
        ArrayList<String> input = Input.getInput(INPUT_LIMIT, sc);
        return convertStringArrayListToLineArrayList(input);
    }

    /**
     * Convert arraylist of string object into arraylist of line object.
     * @param   stringArrayList Arraylist of string.
     * @return                  Arraylist of line object.
     */
    private static ArrayList<Line> convertStringArrayListToLineArrayList(ArrayList<String> stringArrayList) {
        ArrayList<Line> lines = new ArrayList<>();

        for(String inputLine : stringArrayList) {
            ArrayList<String> words = convertStringArrayToArrayList(inputLine.split(SPACE_REGEX));
            lines.add(new Line(words));
        }
        return lines;
    }

    /**
     * Convert array of string into arraylist of string.
     * @param   stringArray Array of string.
     * @return              Arraylist of string.
     */
    private static ArrayList<String> convertStringArrayToArrayList(String[] stringArray) {
        ArrayList<String> list = new ArrayList<>();
        for(String word: stringArray) {
            list.add(word.trim());
        }
        return list;
    }
}