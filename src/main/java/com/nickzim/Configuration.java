package com.nickzim;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(Configuration.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getToken(){
        return properties.getProperty("token");
    }

    public static String getConfirmMessage(){
        return properties.getProperty("confirm_message");
    }

    public static Double getApiVersion(){
        return Double.parseDouble(properties.getProperty("version"));
    }


}
