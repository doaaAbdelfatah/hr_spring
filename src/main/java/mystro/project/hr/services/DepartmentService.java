package mystro.project.hr.services;

import mystro.project.hr.models.Department;
import mystro.project.hr.models.Job;
import mystro.project.hr.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department){
       return departmentRepository.save(department); // insert into departments (id , name ,manager) values(?,?,?)
    }

    public List<Department> allDept(){
        return departmentRepository.findAll(); // select * from departments
    }

    public void delete(Department department){
        departmentRepository.delete(department);
    }

    public Department get( Integer id){
        return departmentRepository.findById(id).get();

    }
}
