package main.java.com.alpashaev.user;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UsersOperations {

    public static List<Users> implementationOfUsers() {
        List<Users> users = Arrays.asList(
                new Users("Vasya", 16, "Dnipro"),
                new Users("Petya", 23, "Dnipro"),
                new Users("Elena", 42, "Lutsk"),
                new Users("Elena", 92, "Chernigov"),
                new Users("Sergey", 5, "Kyiv"),
                new Users("Marina", 32, "Kyiv"),
                new Users("Ivan Ivanovich", 69, "Lviv")
        );
        return users;
    }

    public static void operationsOnUsers(){
        List<Users> user = implementationOfUsers();
        printUsersOlderThan(user, 40);
        printUsersYoungerThanAndForm(user, 50, "Dnipro");
        printAverageFromCity(user, "Lviv");
        printCountUsersFromCity(user, "Kyiv");
        printUsersSortedWithAge(user, 3);
    }

    private static void printUsersOlderThan(List<Users> users, int age) {
        System.out.println("\nUsers older than " + age + "");
        users.stream()
                .filter(user -> user.getAge() > age)
                .forEach(System.out::println);
    }

    private static void printUsersYoungerThanAndForm(List<Users> users, int age, String city) {
        System.out.println("\nUsers younger than " + age + " and from Dnipro");
        users.stream()
                .filter(user -> user.getAge() < age && user.getCity().equals(city))
                .forEach(System.out::println);
    }

    private static void printAverageFromCity(List<Users> users, String city) {
        AtomicReference<Double> avgAge = new AtomicReference<>((double) 0);
        users.stream()
                .filter(user -> user.getCity().equals(city))
                .mapToInt(Users::getAge)
                .average()
                .ifPresent(avgAge::set);

        System.out.println("\nAverage age of users from " + city + "  " + avgAge);

    }

    private static void printCountUsersFromCity(List<Users> users, String city) {
        int notFromKiev = (int) users.stream()
                .filter(user -> !user.getCity().equals(city))
                .count();
        System.out.println("Number of users who do not live in Kiev " + notFromKiev);
    }

    private static void printUsersSortedWithAge(List<Users> users, int value) {
        System.out.println("\nThe first 3 users in the sorted list " + value);
        users.stream()
                .sorted(Comparator.comparingInt(Users::getAge))
                .limit(value)
                .forEach(System.out::println);
    }
}
