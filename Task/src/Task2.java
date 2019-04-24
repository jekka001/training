import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Peter");
        list.add("Ivan");
        list.add("Max");
        list.add("Kostia");
        list.stream().sorted()
                .map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
