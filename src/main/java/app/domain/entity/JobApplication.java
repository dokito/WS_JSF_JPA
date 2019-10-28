package app.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "job_application")
public class JobApplication extends BaseEntity {

    private Sector sector;
    private String profession;
    private BigDecimal salary;
    private String description;

    public JobApplication() {
    }

    @Column(name = "sector", nullable = false)
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Column(name = "profession")
    @Enumerated(EnumType.STRING)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
