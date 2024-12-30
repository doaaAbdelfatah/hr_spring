package mystro.project.hr.controllers;

import mystro.project.hr.models.Department;
import mystro.project.hr.models.Employee;
import mystro.project.hr.repositories.DepartmentRepository;
import mystro.project.hr.services.DepartmentService;
import mystro.project.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService ;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("depts" , departmentService.allDept());
        return "employees" ; //  templates/employees.html
    }
    @PostMapping("/create")
    public String create(@RequestParam(value = "first_name") String first_name,
                         @RequestParam(value = "last_name") String last_name,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "phone") String phone,
                         @RequestParam(value = "job") String job ,
                         @RequestParam(value = "department_id") int department_id) {

        Department department = departmentService.get(department_id);
        Employee employee = new Employee();
        employee.setFirstName(first_name);
        employee.setLastName(last_name);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setJob(job);
        employee.setDepartment(department);
        employeeService.save(employee);

        return "redirect:/emps/show";
    }
}
