package org.shirokuma.utils;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private static Properties appProperties;

    public static Properties appProperties() {
        if (appProperties == null) {
            try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("application.properties")) {

                if (input == null) {
                    throw new FileNotFoundException("Unable to load application.properties file from the resources directory");
                }
                appProperties = new Properties();
                appProperties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return appProperties;
    }

}
