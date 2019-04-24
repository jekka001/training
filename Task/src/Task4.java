import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        method(25214903917l, 11, (long) Math.pow(2, 48), 0).forEach(x-> System.out.println(x));
    }

    public static Stream<Long> method(long a, long c, long m, int seed){
        LongStream longStream = LongStream
                .iterate(seed, x -> (a * x + c) % m)
                .limit(1000);
        return longStream.boxed();
    }
}
