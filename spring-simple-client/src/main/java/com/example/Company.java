package com.example;

/**
 * Created by sai on 16-8-7.
 */
public class Company
{

    String name;
    String location;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
