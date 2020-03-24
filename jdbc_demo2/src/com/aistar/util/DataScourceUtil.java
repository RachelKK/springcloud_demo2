package com.aistar.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获得数据源信息的类
 */
public class DataScourceUtil {


    private static Properties properties = new Properties();

    // db_config.properties 只加载一次
    static {
        InputStream is = null;
        try {
            is =  new FileInputStream(System.getProperty("user.dir") + "/src/com/aistar/config/db_config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDriverName(){
        return properties.getProperty("driverName");
    }

    public static String getUrl(){
        return properties.getProperty("url");
    }

    public static String getUsername(){
        return properties.getProperty("username");
    }

    public static String getPassword(){
        return properties.getProperty("password");
    }


}
