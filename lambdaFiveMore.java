import java.util.Arrays;
import java.util.List;

public class lambdaFiveMore {
    

    public static void main(String[] args) {

        // =========================
        // Problem 1: Square of Each Number
        // =========================
        List<Integer> nums = Arrays.asList(2, 4, 6, 8);

        System.out.println("Squares:");
        nums.stream()
            .map(n -> n * n)
            .forEach(System.out::println);


        // =========================
        // Problem 2: Remove Duplicates
        // =========================
        List<Integer> dup = Arrays.asList(1,2,2,3,3,4);

        System.out.println("After Removing Duplicates:");
        dup.stream()
           .distinct()
           .forEach(System.out::println);


        // =========================
        // Problem 3: Find First Number > 5
        // =========================
        int first = nums.stream()
                        .filter(n -> n > 5)
                        .findFirst()
                        .get();

        System.out.println("First Number > 5: " + first);


        // =========================
        // Problem 4: Convert Strings to Uppercase
        // =========================
        List<String> names = Arrays.asList("ram", "shyam", "mohan");

        System.out.println("Uppercase Names:");
        names.stream()
             .map(s -> s.toUpperCase())
             .forEach(System.out::println);


        // =========================
        // Problem 5: Average of Numbers
        // =========================
        double avg = nums.stream()
                         .mapToInt(n -> n)
                         .average()
                         .getAsDouble();

        System.out.println("Average: " + avg);
    }
}
