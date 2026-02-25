
import java.util.*;
import java.util.stream.*;

public class LambdaHardProblems {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("eat","tea","tan","ate","nat","bat");

        Map<String, List<String>> anagrams =
                words.stream()
                     .collect(Collectors.groupingBy(word -> {
                         char[] arr = word.toCharArray();
                         Arrays.sort(arr);
                         return new String(arr);
                     }));

        System.out.println(anagrams.values());

                String str = "swiss";

        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result);

        
}
}
