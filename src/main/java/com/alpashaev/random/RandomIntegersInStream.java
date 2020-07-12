package main.java.com.alpashaev.random;

import java.util.List;

public class RandomIntegersInStream extends RandomFill {
    public static void randomIntegersInStream() {
        System.out.println("\nRandom values : " + randomValues);
        findMinValue(randomValues);
        findMaxValue(randomValues);
        valueDivisibleByTwo(randomValues);
        increaseValuesByTen(randomValues);
    }

    public static void findMinValue(List<Integer> randomValues) {
        int min = randomValues.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("Min value : " + min);
    }

    public static void findMaxValue(List<Integer> randomValues) {
        int max = randomValues.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max value : " + max);
    }

    public static void valueDivisibleByTwo(List<Integer> randomValues) {
        System.out.println("Numbers which divide by 2 : ");
        randomValues.stream()
                .filter(integer -> integer % 2 == 0)
                .forEach(integer -> System.out.println(integer + ", "));
    }

    public static void increaseValuesByTen(List<Integer> randomValues) {
        System.out.println("Numbers increased by 10 ");
        randomValues.stream()
                .mapToInt(value -> value + 10)
                .boxed()
                .forEach(integer -> System.out.println(integer + ","));
    }
}
