import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Peter");
        list.add("Ivan");
        list.add("Max");
        list.add("Kostia");
        //task1
        /*list.stream()
                .filter(x -> list.indexOf(x)%2 != 0)
                .forEach(x -> System.out.println(list.indexOf(x) + "." + x));
        */
        //task2
         /*list.stream().sorted()
                 .map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        */
         //task3
        //Stream.of(Arrays.asList("1,2,0","4,5")).flatMap(Collection::stream).forEach(x -> System.out.print(x + ","));
        //task4

    }
}
