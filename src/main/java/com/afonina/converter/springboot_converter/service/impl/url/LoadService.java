package com.afonina.converter.springboot_converter.service.impl.url;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class LoadService {
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
