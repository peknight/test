package com.peknight.test.client.service;

import com.peknight.test.client.TestClientApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author PeKnight
 *
 * Created by PeKnight on 2017/7/31.
 */
public interface GlobalService {
    ThreadLocal<String> SESSION_ID = new ThreadLocal<>();

    Logger LOGGER = LoggerFactory.getLogger(TestClientApplication.class);

    String EXIT = "#e";
    String INFO = "#i";

    default void parseInput(String input) throws Exception {
        switch (input) {
            case EXIT:
                exit();
                break;
            case INFO:
                info();
                break;
            default:
                parseCustomInput(input);
                break;
        }
    }

    void parseCustomInput(String input) throws Exception;

    void exit();

    default void globalInfo() {
        LOGGER.info("[HINT] # GLOBAL INFO #");
        LOGGER.info("[HINT] Input '{}' -> Exit", EXIT);
        LOGGER.info("[HINT] Input '{}' -> Print Info", INFO);
    }

    void currentInfo();

    default void info() {
        globalInfo();
        currentInfo();
    }

    void home() throws Exception;
}
