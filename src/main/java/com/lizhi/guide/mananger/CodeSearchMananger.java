package com.lizhi.guide.mananger;


import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 介入elasticSearch全文检索项目
 */
public class CodeSearchMananger {
    private static Map<String, String> ctxPropertiesMap = null;

    static {
        try {
            String path = CodeSearchMananger.class.getResource("/config")
                    .getPath();
            File dic = new File(path);
            ctxPropertiesMap = new HashMap<String, String>();
            for (File file : dic.listFiles()) {
                if (file.getName().endsWith(".properties")) {
                    Properties prop = new Properties();
                    prop.load(new FileInputStream(file));
                    Enumeration<Object> keys = prop.keys();
                    while (keys.hasMoreElements()) {
                        String key = keys.nextElement().toString();
                        String value = prop.getProperty(key);
                        ctxPropertiesMap.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            // do nothing
        }
    }


    public static String getContextProperty(String name) {
        return (String) ctxPropertiesMap.get(name);
    }
}

