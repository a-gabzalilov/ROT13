package com.company;

import java.io.*;
import java.util.logging.*;

public class CreateLogger {

    public static Logger mylogger;
    static void CreateLogger(String filename, String message) {
        mylogger = Logger.getLogger(filename);
        mylogger.setUseParentHandlers(false);
        try {

            FileHandler filehandler = new FileHandler(filename);
            mylogger.addHandler(filehandler);

            SimpleFormatter formatter = new SimpleFormatter();
            filehandler.setFormatter(formatter);
        } catch (IOException exception) {
            System.out.println("Unable to create logger");
        }
        mylogger.severe(message);
    }
}
