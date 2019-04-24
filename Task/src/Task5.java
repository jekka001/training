import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static java.util.stream.Collectors.toList;

public class Task5 {
    public static void main(String[] args) {
        Stream<Integer> odd = IntStream.iterate(1, x -> x + 2).limit(10).boxed();
        Stream<Integer> even = IntStream.iterate(2, x -> x + 2).limit(13).boxed();
        List<Integer> actual = zip(odd, even).collect(toList());
        List<Integer> expected = IntStream.rangeClosed(1, 20).boxed().collect(toList());
        System.out.println(actual);
        System.out.println(expected);
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Queue<T> elementsA = first.collect(Collectors.toCollection(LinkedList::new));
        Queue<T> elementsB = second.limit(elementsA.size()).collect(Collectors.toCollection(LinkedList::new));
        return Stream.generate(new Supplier<T>() {
            boolean first = true;

            @Override
            public T get() {
                Queue<T> queue = first ? elementsA : elementsB;
                first = !first;
                return queue.poll();
            }
        }).limit(Math.min(elementsA.size(), elementsB.size()) * 2);
    }
}
