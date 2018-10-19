package io.codebeneath;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Assumes message files are relative to java execution dir and loads them as File object.
 */
public class MessageManager {

    public static final String MSG_NOT_FOUND = "MSG_NOT_FOUND";
    
    private MessageManager() {
    }

    public static String getMessage(String messageKey) {

        Properties prop = new Properties();
        System.out.println("[...] Loading messages from: " + System.getProperty("user.dir"));
        try(InputStream input = new FileInputStream("msgs/a-messages.properties")) {
            prop.load(input);
        } catch (Exception e) {
            System.out.println("Could not load messages: " + e);
        }
        return prop.getProperty(messageKey, "MSG_NOT_FOUND");
    }
}
