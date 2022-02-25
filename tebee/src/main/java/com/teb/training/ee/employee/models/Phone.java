package com.teb.training.ee.employee.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(table = "id_generator",
                name = "gen_phone_id",
                pkColumnName = "gen_type",
                pkColumnValue = "phone",
                valueColumnName = "gen_id",
                initialValue = 0,
                allocationSize = 1)
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_phone_id")
    private Long   phoneId;
    private String phoneName;
    private String number;
    //    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //    private Employee employee;

    public String getPhoneName() {
        return this.phoneName;
    }

    public void setPhoneName(final String phoneNameParam) {
        this.phoneName = phoneNameParam;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number,
                            this.phoneId,
                            this.phoneName);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Phone other = (Phone) obj;
        return Objects.equals(this.number,
                              other.number)
               && Objects.equals(this.phoneId,
                                 other.phoneId)
               && Objects.equals(this.phoneName,
                                 other.phoneName);
    }


}
