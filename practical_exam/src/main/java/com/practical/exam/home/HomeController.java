package com.practical.exam.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@PostMapping("/")
	public String homeIndex() {
		return "hello";
	}
}
