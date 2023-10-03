package com.Day1.intro.Controller.model;

import jakarta.persistence.*;

@Entity // convert class file into table
@Table(name = "_student")// to modify the table name by default table name will be class name(student here)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String dept;

    public Student() {
        super();
    }

    public Student(Long id, String name, String email, String dept) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
