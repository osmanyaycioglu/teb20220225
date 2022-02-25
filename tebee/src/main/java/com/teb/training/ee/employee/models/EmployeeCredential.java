package com.teb.training.ee.employee.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(table = "id_generator",
                name = "gen_employeecred_id",
                pkColumnName = "gen_type",
                pkColumnValue = "employeecred",
                valueColumnName = "gen_id",
                initialValue = 0,
                allocationSize = 1)

public class EmployeeCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_employeecred_id")
    private Long     empCreId;
    private String   username;
    private String   password;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "empId", nullable = false)
    private Employee employee;

    public Long getEmpCreId() {
        return this.empCreId;
    }

    public void setEmpCreId(final Long empCreIdParam) {
        this.empCreId = empCreIdParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employeeParam) {
        this.employee = employeeParam;
    }


}
