package com.teb.training.ee.employee.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmployeeCredential {

    @Id
    @GeneratedValue
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


}
