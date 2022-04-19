package com.afonina.converter.springboot_converter;

import com.afonina.converter.springboot_converter.service.impl.MarshallerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConverterApplicationTests {

	MarshallerService marshallerService = new MarshallerService();
	private String pathName = "src/main/resources/xml/valutesFromCBRF.xml";

	@Test
	void contextLoads() {

		System.out.println(marshallerService.getValutesCursesFromXmlFile(pathName));
	}

}
