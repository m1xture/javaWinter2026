package main.java.com.app.hw24;

import main.java.com.app.hw24.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("message was sent", LogTypes.INFO);
        logger.log("error occured while sending message", LogTypes.ERROR);
        Logger logger2 = Logger.getInstance();
    }
}
