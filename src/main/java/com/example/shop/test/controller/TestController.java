package com.example.shop.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.test.dto.TestDto;


@RestController
public class TestController {

	@GetMapping(value = "/")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/test")
	public TestDto test() {
		TestDto dto = new TestDto();
		dto.setName("홍길동");
		dto.setAge(10);
		return dto;
	}
}
