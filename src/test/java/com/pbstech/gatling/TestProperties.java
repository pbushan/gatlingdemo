package com.pbstech.gatling;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestProperties {
    private static final Properties properties = new Properties();;
    TestProperties() {
    }
    @NotNull
    public static Properties getProperties() {
        try {
            properties.load(TestProperties.class.getClassLoader().getResourceAsStream("test.properties"));
        }
        catch (IOException e) {
            Logger.getLogger(TestProperties.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return properties;
    }
}
