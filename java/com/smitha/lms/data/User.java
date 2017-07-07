package com.smitha.lms.data;

import java.io.Serializable;

/**
 * Created by Smitha on 28-06-2017.
 */

public class User implements Serializable
{

    private int id;
    private String name;
    private int age;
    private String sex;
    private double salary;
    private int rating;


    public User(int id,String name, int age,String sex, double salary,  int rating) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.rating = rating;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (Double.compare(user.salary, salary) != 0) return false;
        if (rating != user.rating) return false;
        if (!name.equals(user.name)) return false;
        return sex.equals(user.sex);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + sex.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + rating;
        return result;
    }
}


