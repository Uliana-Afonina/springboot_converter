package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MarshallerService {

    public ValutesCurses getValutesCurses() {
        ValutesCurses valutesCurses = null;
        File file = new File("src/main/resources/xml/file_name.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ValutesCurses.class);
            Unmarshaller unmarshaller  = jaxbContext.createUnmarshaller();
            valutesCurses = (ValutesCurses) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return valutesCurses;
    }
}
