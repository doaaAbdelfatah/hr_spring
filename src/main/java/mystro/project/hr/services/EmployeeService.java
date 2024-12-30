package mystro.project.hr.services;

import mystro.project.hr.models.Employee;
import mystro.project.hr.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
       return  this.employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return  this.employeeRepository.findAll();
    }

    public Employee get(int id){
        return  this.employeeRepository.findById(id).get();
    }


    public void delete(Employee employee){
        this.employeeRepository.delete(employee);
    }

}
