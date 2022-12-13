package com.example.demo.common;

import com.example.demo.employee.model.Employee;
import com.example.demo.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Slf4j
@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        log.debug("displayHome");
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employeesList",employees);
        return "main/home";
    }
}
