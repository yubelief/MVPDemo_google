package com.adouble.mvpdemotodoapp.bean;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public class UserInfo {

    private String name;
    private int age;
    private String address;

    public UserInfo(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public UserInfo() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
