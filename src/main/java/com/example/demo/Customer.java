package com.example.demo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class Customer {
    private String ID;
    private String name;
    private boolean sex;
    private int age;

    public Customer(){
        ID = "";
        name = null;
        sex = true;
        age = 0;
    }

    public Customer(String ID, String n, boolean s, int a){
        this.ID = ID;
        this.name = n;
        this.sex = s;
        if (a > 0){
            this.age = a;
        }else{
            this.age = 0;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
