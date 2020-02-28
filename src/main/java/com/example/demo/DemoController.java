package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class DemoController
{
	@GetMapping
	public Mono<Model> findAll()
	{
		return 	Mono.defer(() -> Mono.just(new Model("test")));
	}

	public static class Model{
		public String value;

		Model(){}

		Model(final String value)
		{
			this.value = value;
		}
	}
}
