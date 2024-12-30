package mystro.project.hr.controllers;

import mystro.project.hr.models.Job;
import mystro.project.hr.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("jobs" , jobService.all());
        return "jobs";
    }
    @PostMapping("/save")
    public String save(@RequestParam(value = "name") String name ,@RequestParam(value = "sal") double sal){
        Job job = new Job();
        job.setName(name);
        job.setSalaryAvg(sal);
        jobService.save(job);
        return "redirect:/jobs/show";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") int id){
        Job job = jobService.get(id);
        jobService.delete(job);
        return "redirect:/jobs/show";
    }
}
