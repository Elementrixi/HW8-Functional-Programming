package main.java.com.alpashaev.random;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class RandomFill {
    static List<Integer> randomValues = IntStream.range(1, 100).boxed()
            .collect(groupingBy(i -> Math.random()))
            .values().stream().flatMap(Collection::stream)
            .limit(15).collect(toList());
}
