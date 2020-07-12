package main.java.com.alpashaev.user;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UsersOperations {
    public static void usersListOperations() {
        List<Users> users = Arrays.asList(
                new Users("Вася", 16, "Днепр"),
                new Users("Петя", 23, "Днепр"),
                new Users("Елена", 42, "Луцк"),
                new Users("Елена", 92, "Чернигов"),
                new Users("Сергей", 5, "Киев"),
                new Users("Маринв", 32, "Киев"),
                new Users("Иван Иванович", 69, "Львов")
        );
        printUsersOlderThan(users, 40);
        printUsersYoungerThanAndForm(users, 50, "Днепр");
        printAverageFromCity(users, "Львов");
        printCountUsersFromCity(users, "Киев");
        printUsersSortedWithAge(users, 3);
    }

    private static void printUsersOlderThan(List<Users> users, int age) {
        System.out.println("\nUsers older than " + age + "");
        users.stream()
                .filter(user -> user.getAge() > age)
                .forEach(System.out::println);
    }

    private static void printUsersYoungerThanAndForm(List<Users> users, int age, String city) {
        System.out.println("\nUsers younger than " + age + " and from Днепр");
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

        System.out.println("\nAverage age of users from " + city + " is " + avgAge);

    }

    private static void printCountUsersFromCity(List<Users> users, String city) {
        int notFromKiev = (int) users.stream()
                .filter(user -> !user.getCity().equals(city))
                .count();
        System.out.println("\nAmount of users who don't live in Kiev " + notFromKiev);
    }

    private static void printUsersSortedWithAge(List<Users> users, int value) {
        System.out.println("\nFirst three users in sorted list " + value);
        users.stream()
                .sorted(Comparator.comparingInt(Users::getAge))
                .limit(value)
                .forEach(System.out::println);
    }
}