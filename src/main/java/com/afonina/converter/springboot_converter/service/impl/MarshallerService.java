package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class MarshallerService {
//"src/main/resources/xml/valutesFromCBRF.xml"

    public ValutesCurses getValutesCursesFromXmlFile(String pathName) {
        ValutesCurses valutesCurses = null;
        File file = new File(pathName);
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
