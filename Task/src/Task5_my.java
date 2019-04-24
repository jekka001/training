import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Task5_my {
    public static void main(String[] args) {
        Stream<Integer> odd = IntStream.iterate(1, x -> x + 2).limit(10).boxed();
        Stream<Integer> even = IntStream.iterate(2, x -> x + 2).limit(5).boxed();
        zip(odd, even).collect(toList());
        List<Integer> actual = zip(odd, even).collect(toList());
        List<Integer> expected = IntStream.rangeClosed(1, 20).boxed().collect(toList());
        System.out.println(actual);
        System.out.println(expected);
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        long minFirst = first.count();
        long minSecond = second.count();
        long min = minFirst > minSecond ? minSecond: minFirst;
        System.out.println(min);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < min; i++){
            list.add(first);
        }
        return null;
    }
}
