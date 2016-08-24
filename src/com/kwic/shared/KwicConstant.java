package com.kwic.shared;

/**
 * Created by kylel on 24/8/2016.
 */
public class KwicConstant {
    /**
     * Number of lines that can be input.
     */
    public static final int INPUT_LIMIT = 9999;

    /**
     * Number of ignored words that can be input.
     */
    public static final int IGNORE_LIMIT = 999;

    /**
     * Constant to denote Manual input
     */
    public static final int MANUAL_INPUT = 1;

    /**
     * Constant to denote File input
     */
    public static final int FILE_INPUT = 2;

    /**
     * Constant to denote File input
     */
    public static final int INVALID_INPUT_METHOD = -1;

    public static final String WELCOME_MESSAGE = "Welcome to KWIC Index Generator";

    public static final String INPUT_METHOD_MESSAGE = "Please indicate your preference for input:\n" +
            "Enter '" + MANUAL_INPUT + "' to input lines manually\n" +
            "Enter '" + FILE_INPUT + "' to input lines through a file";

    public static final String INVALID_INPUT_METHOD_MESSAGE = "Please enter a valid option:";

    public static final String INPUT_LINES_FILE_NAME_MESSAGE = "Enter input file name for lines:";

    public static final String INVALID_FILE_NAME_MESSAGE = "Please enter a valid file name:";

    public static final String INPUT_IGNORE_FILE_NAME_MESSAGE = "Enter input file name for ignored words:";

    public static final String INPUT_LINES_MESSAGE = "Enter each line (max. " + INPUT_LIMIT + ") followed by enter " +
            "(to terminate, enter an empty line) :";

    public static final String INPUT_IGNORED_WORDS = "Enter each ignored words (max. " + IGNORE_LIMIT + ") followed by enter " +
            "(to terminate, enter an empty line):";

    public static final String OUTPUT_DISPLAY_MESSAGE = "Generated KWIC index:";
}
