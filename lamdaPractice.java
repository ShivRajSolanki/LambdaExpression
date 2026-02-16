import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lamdaPractice{
    public static void main(String[] args) {
        // -------------------------------
        // 1️⃣ Filter Even Numbers
        // -------------------------------
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evens);


        // -------------------------------
        // 2️⃣ Square Each Number
        // -------------------------------
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Squares: " + squares);


        // -------------------------------
        // 3️⃣ Find Sum of All Numbers
        // -------------------------------
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);


        // -------------------------------
        // 4️⃣ Sort Strings by Length
        // -------------------------------
        List<String> names = Arrays.asList("Shivraj", "Ram", "Amit", "Krishna");

        List<String> sortedByLength = names.stream()
                .sorted((a, b) -> a.length() - b.length())
                .collect(Collectors.toList());

        System.out.println("Sorted by Length: " + sortedByLength);


        // -------------------------------
        // 5️⃣ Count Strings Starting with 'A'
        // -------------------------------
        long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Count starting with A: " + count);

    }
}