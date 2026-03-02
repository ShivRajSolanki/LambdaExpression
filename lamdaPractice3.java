import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class lamdaPractice3 {

    public static void main(String[] args) {

        // 1️⃣ Longest String in List
        List<String> words = Arrays.asList("java", "springboot", "microservices", "api");
        String longest = words.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println("Longest String: " + longest);


        // 2️⃣ Second Highest Number
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 25, 30);
        Integer secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Highest: " + secondHighest);


        // 3️⃣ First Non-Repeating Character
        String input = "swiss";
        Character firstNonRepeat = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First Non-Repeating: " + firstNonRepeat);


        // 4️⃣ Group Anagrams
        List<String> anagrams = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Map<String, List<String>> grouped = anagrams.stream()
                .collect(Collectors.groupingBy(word ->
                        word.chars()
                                .sorted()
                                .mapToObj(c -> String.valueOf((char) c))
                                .collect(Collectors.joining())
                ));
        System.out.println("Grouped Anagrams: " + grouped);


        // 5️⃣ Partition Prime & Non-Prime
        List<Integer> nums = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitioned = nums.stream()
                .collect(Collectors.partitioningBy(n ->
                        IntStream.rangeClosed(2, (int) Math.sqrt(n))
                                .noneMatch(i -> n % i == 0)
                ));

        System.out.println("Prime Numbers: " + partitioned.get(true));
        System.out.println("Non-Prime Numbers: " + partitioned.get(false));
    }
}