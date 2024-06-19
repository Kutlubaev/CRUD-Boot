package ru.kutlubaev.boot.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "name should be not empty")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+", message = "Имя должно содержать только буквы")
    @Size(min = 2 , max = 30)
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "surname should be not empty")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+", message = "Фамилия должна содержать только буквы")
    @Size(min = 2 , max = 30)
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

}
