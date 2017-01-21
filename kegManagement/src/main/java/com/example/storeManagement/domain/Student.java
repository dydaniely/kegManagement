package com.example.storeManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created by Daniel on 1/10/2017.
 */

@Entity
public class Student {
    @GeneratedValue
    @Id
    private int Id;
    private String Name;
    private int Age;

    public Student(String name, int age) {
        Name = name;
        Age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

}
