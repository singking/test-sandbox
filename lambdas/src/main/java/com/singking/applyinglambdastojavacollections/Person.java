package com.singking.applyinglambdastojavacollections;

public class Person {
    String name;
    String lastname;
    int age;
    Sex sex;

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, String lastname, int age, Sex sex) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", lastname=" + lastname + ", age=" + age + "]";
    }
}
