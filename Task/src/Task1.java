import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Peter");
        list.add("Ivan");
        list.add("Max");
        list.add("Kostia");
        list.stream()
                .filter(x -> list.indexOf(x)%2 != 0)
                .forEach(x -> System.out.println(list.indexOf(x) + "." + x));
    }
}
