package com.teb.training.ee.employee.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.teb.training.ee.rest.models.EGender;

@Entity
@TableGenerator(table = "id_generator",
                name = "gen_employee_id",
                pkColumnName = "gen_type",
                pkColumnValue = "employee",
                valueColumnName = "gen_id",
                initialValue = 0,
                allocationSize = 1)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_employee_id")
    private Long               empId;
    private String             name;
    private String             surname;
    private Integer            height;
    private Integer            weight;
    private EGender            gender;
    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private EmployeeCredential employeeCredential;

    //    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Phone> phones;

    @Version
    private Long       xyz;


    public Long getEmpId() {
        return this.empId;
    }


    public void setEmpId(final Long empIdParam) {
        this.empId = empIdParam;
    }


    public EmployeeCredential getEmployeeCredential() {
        return this.employeeCredential;
    }


    public void setEmployeeCredential(final EmployeeCredential employeeCredentialParam) {
        this.employeeCredential = employeeCredentialParam;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Employee [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }


    public Set<Phone> getPhones() {
        return this.phones;
    }


    public void setPhones(final Set<Phone> phonesParam) {
        this.phones = phonesParam;
    }


}
