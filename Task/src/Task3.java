import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Stream.of(Arrays.asList("1,2,0","4,5")).flatMap(Collection::stream).forEach(x -> System.out.print(x + ","));

    }
}
