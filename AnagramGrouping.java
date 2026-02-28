import java.util.*;
import java.util.stream.*;

public class AnagramGrouping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

        Collection<List<String>> result = words.stream()
                .collect(Collectors.groupingBy(word -> {
                    char[] ch = word.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);
                }))
                .values();

        System.out.println(result);
    }
}