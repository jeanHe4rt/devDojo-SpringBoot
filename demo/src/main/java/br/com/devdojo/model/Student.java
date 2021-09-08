package br.com.devdojo.model;


import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
