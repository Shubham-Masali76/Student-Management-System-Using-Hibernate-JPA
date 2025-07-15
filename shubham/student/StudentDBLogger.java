package com.shubham.student;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentDBLogger extends Thread {
    private static final String LOG_FILE = "student.log";

    
    public static synchronized void run(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fw.write("[" + timestamp + "] " + message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("❌ Logging failed: " + e.getMessage());
        }
    }
}
