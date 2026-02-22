import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class hardProblems {

    public static void main(String[] args) {

        // ------------------ Problem 1 ------------------
        // Find Top 3 Most Frequent Numbers

        List<Integer> nums = Arrays.asList(1,2,3,4,2,3,1,1,4,5,2,2,3);

        List<Integer> top3 =
                nums.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                        .limit(3)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        System.out.println("Top 3 frequent numbers: " + top3);



        // ------------------ Problem 2 ------------------
        // Find Longest Word in Sentence

        String sentence = "Java stream API is very powerful and expressive";

        String longestWord =
                Arrays.stream(sentence.split(" "))
                        .max(Comparator.comparingInt(String::length))
                        .get();

        System.out.println("Longest word: " + longestWord);



        // ------------------ Problem 3 ------------------
        // Check if Two Strings are Anagrams using Lambda

        String str1 = "listen";
        String str2 = "silent";

        boolean isAnagram =
                str1.length() == str2.length() &&
                str1.chars().sorted()
                        .boxed()
                        .collect(Collectors.toList())
                        .equals(
                                str2.chars()
                                        .sorted()
                                        .boxed()
                                        .collect(Collectors.toList())
                        );

        System.out.println("Are Anagrams: " + isAnagram);



        // ------------------ Problem 4 ------------------
        // Partition Employees based on Salary > 50000

        List<Employee> empList = Arrays.asList(
                new Employee("Amit", 40000),
                new Employee("Rahul", 55000),
                new Employee("Neha", 60000),
                new Employee("Priya", 50000),
                new Employee("Ravi", 70000)
        );

        Map<Boolean, List<Employee>> partition =
                empList.stream()
                        .collect(Collectors.partitioningBy(e -> e.salary > 50000));

        System.out.println("Salary > 50000: " + partition.get(true));
        System.out.println("Salary <= 50000: " + partition.get(false));



        // ------------------ Problem 5 ------------------
        // Find Common Elements Between Two Lists

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> list2 = Arrays.asList(4,5,6,7,8,9);

        List<Integer> common =
                list1.stream()
                        .filter(list2::contains)
                        .collect(Collectors.toList());

        System.out.println("Common elements: " + common);
    }
}

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}