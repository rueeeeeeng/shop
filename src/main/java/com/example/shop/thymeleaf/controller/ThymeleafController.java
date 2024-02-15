package com.example.shop.thymeleaf.controller;

import java.awt.Point;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Data;

@Controller
@Data
public class ThymeleafController {

	@GetMapping(value = "/thymeleaf/ex1")
	public String ex1(Model model) {

		Point p = new Point(10, 20);
		
		model.addAttribute("data", p);
		return "thymeleaf/ex1";

//		dto dto = new dto();
//		dto.setX(10);
//		dto.setY(20);
//		model.addAttribute("data", dto);
//		return "thymeleaf/ex1";
	}
}
