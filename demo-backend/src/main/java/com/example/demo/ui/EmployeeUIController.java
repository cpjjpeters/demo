package com.example.demo.ui;
import com.example.demo.employee.persistence.entity.Employee;
import com.example.demo.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/* carlpeters created on 17/12/2022 inside the package - com.example.demo.ui */

@Slf4j
@Controller
@RequestMapping(value = "/employees")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeUIController {

    private final EmployeeRepository employeeRepository;

    public EmployeeUIController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping({"","/", "/all"})
    public String displayEmployees(Model model) {
        log.debug("displayEmployees");
        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        log.debug("displayEmployeeForm");
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        log.debug("handle saving  Employee to DB");
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
}
