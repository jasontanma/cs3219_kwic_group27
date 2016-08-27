package com.kwic.shared;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by kylel on 20/8/2016.
 * Output message on standard output io.
 */
public class Output {
    
    /**
     * Display single line message on standard output io.
     * @param message   String of message to be displayed.
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Display multiple line messages on standard output io.
     * @param list   List of string of messages to be displayed.
     */
    public static void displayArrayList(ArrayList<String> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i).toString());
        }
    }

    /**
     * Create output file with list of String
     * @param list List of string to store in output file
     */
    public static void createOutputFile(ArrayList<String> list) {
        File outputFile;
        try {
            outputFile = new File(KwicConstant.OUTPUT_FILE_NAME);
            if(!outputFile.exists() || outputFile.isDirectory()) {
                outputFile.createNewFile();
            }

            PrintWriter printWriter = new PrintWriter(outputFile);
            for(int i = 0; i < list.size(); i++) {
                printWriter.println(i + ": " + list.get(i).toString());
            }
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}