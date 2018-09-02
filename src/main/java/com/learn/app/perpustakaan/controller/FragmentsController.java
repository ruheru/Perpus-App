package com.learn.app.perpustakaan.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan
public class FragmentsController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/hallojava")
	public String halloJava() {
		return "/fragments/hallojava";
	}
}
