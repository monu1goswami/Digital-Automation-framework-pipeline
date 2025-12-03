package com.automation.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static Properties initProperties() {
        properties = new Properties();

        // read env from JVM argument; default = "dev"
        String env = System.getProperty("env", "dev");
        String filePath = "src/main/resources/config-" + env + ".properties";

        try (FileInputStream ip = new FileInputStream(filePath)) {
            properties.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file: " + filePath);
        }

        return properties;
    }

    public static String get(String key) {
        if (properties == null) {
            initProperties();
        }
        return properties.getProperty(key);
    }
}
