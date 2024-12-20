package mystro.project.hr.services;

import mystro.project.hr.models.Job;
import mystro.project.hr.repositories.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    public final JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public List<Job> all(){
        return jobRepo.findAll();
    }

    public Job save( Job job){
        return jobRepo.save(job);
    }

    public void delete(Job job){
        jobRepo.delete(job);
    }

    public Job get( Integer id){
       return jobRepo.findById(id).get();

    }
}
