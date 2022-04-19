package com.afonina.converter.springboot_converter.service.impl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoadService {
//    private static final int CONNECTION_TIMEOUT = 10000;
//    private static final int READ_TIMEOUT = 100;
// url = http://www.cbr.ru/scripts/XML_daily.asp
//    filePath = src/main/resources/xml/file_name.xml
    public void loadXMLfromURL(String url, String filePath) {
        try {
            FileUtils.copyURLToFile(
                    new URL(url),
                    new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
