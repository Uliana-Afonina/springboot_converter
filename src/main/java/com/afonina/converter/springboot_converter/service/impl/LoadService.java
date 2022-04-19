package com.afonina.converter.springboot_converter.service.impl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoadService {
//    private static final int CONNECTION_TIMEOUT = 10000;
//    private static final int READ_TIMEOUT = 100;

    public void loadXMLfromURL() {
        try {
//            FileUtils.copyURLToFile(
//                    new URL("http://www.cbr.ru/scripts/XML_daily.asp"),
//                    new File("src/main/java/forSulimov/resources/file_name.xml"),
//                    CONNECTION_TIMEOUT,
//                    READ_TIMEOUT);
            FileUtils.copyURLToFile(
                    new URL("http://www.cbr.ru/scripts/XML_daily.asp"),
                    new File("src/main/resources/xml/file_name.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
