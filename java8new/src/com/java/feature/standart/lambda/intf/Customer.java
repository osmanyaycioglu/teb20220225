package com.java.feature.standart.lambda.intf;


public class Customer {

    private String  username;
    private String  name;
    private String  surname;
    private Integer weight;
    private Integer height;
    private Integer age;

    public static Customer newInstance() {
        return new Customer();
    }

    public Integer getHeight() {
        return this.height;
    }

    public Customer setHeight(final Integer heightParam) {
        this.height = heightParam;
        return this;
    }

    public Integer getAge() {
        return this.age;
    }

    public Customer setAge(final Integer ageParam) {
        this.age = ageParam;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Customer setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Customer setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Customer setWeight(final Integer weightParam) {
        this.weight = weightParam;
        return this;
    }


    public String getUsername() {
        return this.username;
    }

    public Customer setUsername(final String usernameParam) {
        this.username = usernameParam;
        return this;
    }

    @Override
    public String toString() {
        return "Customer [username="
               + this.username
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", age="
               + this.age
               + "]";
    }


}
