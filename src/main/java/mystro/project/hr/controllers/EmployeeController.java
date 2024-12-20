package mystro.project.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

    @GetMapping("/show")
    public String index(){
        return "employees" ; //  templates/employees.html
    }
}
