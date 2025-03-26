package zinjava.madisonportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@PostMapping("/send")
	public String send(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
		return "contact";
	}
}
