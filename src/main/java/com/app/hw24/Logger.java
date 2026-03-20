package main.java.com.app.hw24;

import java.util.Locale;
import java.util.Optional;

public class Logger {
    private static Logger instance;

    static public Logger getInstance() {
        if (Logger.instance == null) {
            System.out.println("New instance of Logger class created");
            Logger.instance = new Logger();
        }
        ;
        return Logger.instance;

    }

    protected void log(String message, LogTypes logType) {
        System.out.printf("%s: %s%n", logType, message.toLowerCase());
    }

    private Logger() {
    }
}
