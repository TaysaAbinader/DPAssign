package org.example.design_patterns.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static Logger instance;

    // Internal state for file handling
    private PrintWriter writer;
    private String fileName;


    private Logger() {
        this.fileName = "logger.txt";
        openFile();
    }


    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    private void openFile() {
        try {
            // append avoid overwriting previous logs
            FileWriter fileWriter = new FileWriter(this.fileName, true);
            this.writer = new PrintWriter(fileWriter);
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    public void setFileName(String newFileName) {
        if (writer != null) {
            writer.close();
        }
        this.fileName = newFileName;
        System.out.println("Switching log file to: " + newFileName);
        openFile();
    }

    public void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }
}
