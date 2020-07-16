package main.java.com.alpashaev.random;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RandomIntegersInStream {
    private static List<Integer> randomValues;

    public static void randomIntegersInStream() {
        randomValues = randomFiller();
        System.out.println("\nRandom values : " + randomValues);
        findMinValue(randomValues);
        findMaxValue(randomValues);
        valueDivisibleByTwo(randomValues, 2);
        increaseValuesByTen(randomValues, 10);
    }

    public static List<Integer> randomFiller() {
        return Stream.generate(()
                -> (int) (Math.random() * 100))
                .limit(15)
                .collect(toList());
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

    public static void valueDivisibleByTwo(List<Integer> randomValues, int number) {
        System.out.println("Numbers which divide by 2 : ");
        randomValues.stream()
                .filter(integer -> integer % number == 0)
                .forEach(integer -> System.out.println(integer + ", "));
    }

    public static void increaseValuesByTen(List<Integer> randomValues, int number) {
        System.out.println("Numbers increased by 10 ");
        randomValues.stream()
                .mapToInt(value -> value + number)
                .boxed()
                .forEach(integer -> System.out.println(integer + ","));
    }
}
