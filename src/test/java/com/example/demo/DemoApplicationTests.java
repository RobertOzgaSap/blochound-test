package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		final WebTestClient baseClient = WebTestClient.bindToApplicationContext(context)
		                                              .configureClient()
		                                              .build();

		baseClient.get()
		          .accept(MediaType.APPLICATION_JSON)
		          .exchange()
		          .expectBody(DemoController.Model.class)
		          .value(b -> Assertions.assertEquals("test", b.value));

	}

}
