package com.api.challenge.pdcase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "spring.h2.console.enabled=true")
class PdCaseApplicationTests {

	@Test
	void contextLoads() {
	}

}
