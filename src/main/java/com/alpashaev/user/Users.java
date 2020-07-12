package main.java.com.alpashaev.user;

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
    public String toString() {
        return "Users{" +
                " имя='" + name + '\'' +
                ", возраст=" + age +
                ", город='" + city + '\'' +
                '}';
    }
}
