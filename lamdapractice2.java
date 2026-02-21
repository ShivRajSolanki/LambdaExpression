import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
public class lamdapractice2 {
    



    public static void main(String[] args) {

        // ------------------ Problem 1 ------------------
        // SECOND HIGHEST NUMBER

        List<Integer> list1 = Arrays.asList(10, 25, 30, 45, 60, 60, 90, 75);

        Integer secondHighest =
                list1.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .get();

        System.out.println("Second Highest: " + secondHighest);



        // ------------------ Problem 2 ------------------
        // GROUP STRINGS BY LENGTH

        List<String> words = Arrays.asList("java", "spring", "boot", "api", "microservice");

        Map<Integer, List<String>> groupByLength =
                words.stream()
                        .collect(Collectors.groupingBy(String::length));

        System.out.println("Grouped by length: " + groupByLength);



        // ------------------ Problem 3 ------------------
        // FIND DUPLICATES

        List<Integer> list2 = Arrays.asList(1,2,3,4,2,5,6,3,7,8,1);

        Set<Integer> duplicates =
                list2.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());

        System.out.println("Duplicates: " + duplicates);



        // ------------------ Problem 4 ------------------
        // FIRST NON REPEATED CHARACTER

        String s = "programming";

        Character firstNonRepeat =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .get();

        System.out.println("First non repeated char: " + firstNonRepeat);



        // ------------------ Problem 5 ------------------
        // MAX SALARY EMPLOYEE

        List<Employee> empList = Arrays.asList(
                new Employee("Amit", 40000),
                new Employee("Rahul", 55000),
                new Employee("Neha", 60000),
                new Employee("Priya", 50000)
        );

        Employee maxSalaryEmp =
                empList.stream()
                        .max(Comparator.comparingInt(e -> e.salary))
                        .get();

        System.out.println("Highest Salary Employee: " +
                maxSalaryEmp.name + " -> " + maxSalaryEmp.salary);
    }
}

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

