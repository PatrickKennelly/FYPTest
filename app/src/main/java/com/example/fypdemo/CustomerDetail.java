package com.example.fypdemo;

public class CustomerDetail {

    private int id;
    private String name;
    private int age;

    //constructor

    public CustomerDetail(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public CustomerDetail() {
    }

    //toString method


    @Override
    public String toString() {
        return "CustomerDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

