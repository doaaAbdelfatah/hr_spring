package mystro.project.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("name", "Doaa Abd Elfatah");
        model.addAttribute("job", "Manager");
        return "home"; // Returns the home.html template
    }
}