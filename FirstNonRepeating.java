import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating {

    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(4, 5, 1, 2, 0, 4, 5, 2);

        Integer result = list.stream()
                
                // Step 1: Count frequency
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                
                // Step 2: Convert map to stream
                .entrySet()
                .stream()
                
                // Step 3: Filter count = 1
                .filter(entry -> entry.getValue() == 1)
                
                // Step 4: Get first key
                .map(Map.Entry::getKey)
                
                .findFirst()
                
                .orElse(null);

        System.out.println("First Non-Repeating Element: " + result);
    }
}