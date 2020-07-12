package main.java.com.alpashaev.user;

import java.util.Objects;

public class Users {
    private String name;
    private int age;
    private String city;

    public Users(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age &&
                name.equals(users.name) &&
                city.equals(users.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }

    @Override
    public String toString() {
        return "Users{" +
                " имя='" + name + '\'' +
                ", возраст=" + age +
                ", город='" + city + '\'' +
                '}';
    }
}
