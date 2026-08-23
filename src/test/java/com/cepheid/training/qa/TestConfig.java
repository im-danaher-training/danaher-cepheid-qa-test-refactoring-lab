package com.cepheid.training.qa;

import java.io.File;

public class TestConfig {

    private TestConfig() { }

    public static String pageUrl(String pageFileName) {
        File appDir = new File(System.getProperty("user.dir"), "app");
        File page = new File(appDir, pageFileName);
        return page.toURI().toString();
    }
}
