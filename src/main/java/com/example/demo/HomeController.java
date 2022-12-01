package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/")
	public String displayHome(Model model) {
		log.debug("displayHome");
//		List<City> projects = proRepo.findAll();
//		model.addAttribute("projectsList",projects);
		return "main/home";
	}

}
