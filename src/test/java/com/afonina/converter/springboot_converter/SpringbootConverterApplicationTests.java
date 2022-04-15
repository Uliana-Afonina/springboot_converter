package com.afonina.converter.springboot_converter;

import com.afonina.converter.springboot_converter.service.MarshallerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConverterApplicationTests {

	MarshallerService marshallerService = new MarshallerService();

	@Test
	void contextLoads() {

		System.out.println(marshallerService.getValutesCurses());
	}

}
