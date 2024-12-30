package mystro.project.hr.controllers;

import mystro.project.hr.models.Department;
import mystro.project.hr.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepatmentController {

    private DepartmentService departmentService;

    public DepatmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping("/create")
    public  String create(@RequestParam(value = "name") String name
            ,@RequestParam(value = "manager") String manager){
        Department department = new Department();
        department.setName(name);
        department.setManager(manager);

        department= departmentService.save(department);

        return  "redirect:/dept/show";
    }

    @GetMapping("/show")
    public String showAll(Model model){

        List<Department> depts =  departmentService.allDept();

        model.addAttribute("depts" , depts);
        return "departments";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") int id){
        Department d =  departmentService.get(id);
        departmentService.delete(d);
        return  "redirect:/dept/show";
    }

    @GetMapping("/edit")
    public String edit(Model model , @RequestParam(value = "id") int id ){
        Department d =  departmentService.get(id);
        model.addAttribute("dept" , d);
        return  "dept_edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam(value = "id" ) int id , @RequestParam(value = "name") String name
            ,@RequestParam(value = "manager") String manager ){
        Department d =  departmentService.get(id);
        d.setName(name);
        d.setManager(manager);
        d= departmentService.save(d);
        return  "redirect:/dept/show";
    }
}
