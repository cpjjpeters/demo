package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String displayHome(Model model) {
		log.debug("displayHome");
//		List<City> projects = proRepo.findAll();
//		model.addAttribute("projectsList",projects);
		return "main/home";
	}

}
