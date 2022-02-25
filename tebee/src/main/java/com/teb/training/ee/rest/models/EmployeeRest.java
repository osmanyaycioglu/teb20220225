package com.teb.training.ee.rest.models;

import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.teb.training.ee.employee.models.Phone;

@XmlRootElement
// @XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeRest {

    @NotEmpty(message = "Name null olamaz")
    @Size(min = 2, max = 20)
    //@StartWith("n:")
    private String     name;
    @NotEmpty(message = "Surname null olamaz")
    @Size(min = 3, max = 25)
    //@StartWith("s:")
    private String     surname;
    @Min(50)
    @Max(300)
    private Integer    height;
    @Positive
    private Integer    weight;
    @NotNull
    private EGender    gender;
    @NotEmpty
    private String     username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String     password;

    private Set<Phone> phones;

    // private LocalDate birthdate;

    // private MilisDuration duration;

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
