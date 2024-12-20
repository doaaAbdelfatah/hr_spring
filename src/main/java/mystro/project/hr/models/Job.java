package mystro.project.hr.models;

import jakarta.persistence.*;

@Entity
@Table(name ="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
   @Column(name = "salary_avg")
    private double salaryAvg;

    public Job() {
    }

    public Job(String name, double salaryAvg) {
        this.name = name;
        this.salaryAvg = salaryAvg;
    }

    public Job(int id, String name, double salaryAvg) {
        this.id = id;
        this.name = name;
        this.salaryAvg = salaryAvg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryAvg() {
        return salaryAvg;
    }

    public void setSalaryAvg(double salaryAvg) {
        this.salaryAvg = salaryAvg;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salaryAvg=" + salaryAvg +
                '}';
    }
}
