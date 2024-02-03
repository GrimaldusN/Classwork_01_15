import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Stream.of("Alice", "Bob", "Charlie", "David").collect(Collectors.toList());
        System.out.println(names);

        Set<Integer> numbers = Stream.of(1, 2, 3, 4, 4, 5, 5).collect(Collectors.toSet());
        System.out.println("Set of unique numbers: " + numbers);

        Map<Integer, List<String>> length = Stream.of("Alice", "Bob", "Charlie", "David").collect(Collectors.groupingBy(String::length));
        System.out.println(length);

        Map<Object, Long> counting = Stream.of(1, 2, 3, 4, 4, 5, 5).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(counting);

        Set<Integer> unique = (Set<Integer>) Stream.of(1, 2, 3, 4, 4, 5, 5).collect(Collectors.toSet());
        System.out.println(unique);

        String length1 = Stream.of("Alice", "Bob", "Charlie", "David")
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(length1);

        Set<Character> uniqueChar= "Alice".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(uniqueChar);

        Map<String, Integer> map = Stream.of(1, 2, 3, 4)
                .collect(Collectors.toMap(i -> "key" + i, i -> i*2));
        System.out.println(map);

        int countingAge = Stream.of(
                new Hero("Bob", 24),
                new Hero("Lol", 12),
                new Hero("Ron",32))
                .collect(Collectors.summingInt(value -> value.age));
        System.out.println(countingAge);

        Map<String, Double> counting2 = Stream.of(
                new Hero("Bob", 24),
                new Hero("Lol", 12),
                new Hero("Ron",32))
                .collect(Collectors.groupingBy(Hero::getName, Collectors.averagingInt(Hero::getAge)));
        System.out.println(counting2);

        List<String> list = new ArrayList<>();
        list.add("Ali  ce");
        list.add("Al i");
        list.add("A li e");
//        System.out.println(uniqueWords(list));
    }
    public static Optional<Integer> countingUneven(List<Integer> list){
        return list.stream()
                .filter(el -> el % 2 == 1)
                .reduce(Integer::sum);
    }

//    public static Set<String> uniqueWords(List<String> input){
//        return input.stream()
//                .sorted()
//                .spliterator().trySplit();
//    }

}
class Hero{
    String name;
    int age;

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Hero name " + name + ", age " + age +" .";
    }
}