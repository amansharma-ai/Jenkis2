import java.util.*;
import java.util.stream.Collectors;

// Employee class (Encapsulation + Constructor + toString)
class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class BestCodeDemo {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Aman", 50000),
            new Employee(102, "Shivansh", 70000),
            new Employee(103, "Manish", 45000),
            new Employee(104, "Neha", 80000)
        );

        // Filter employees with salary > 50k and sort by salary
        List<Employee> highPaid = employees.stream()
                                           .filter(e -> e.getSalary() > 50000)
                                           .sorted(Comparator.comparingDouble(Employee::getSalary))
                                           .collect(Collectors.toList());

        // Print results
        System.out.println("Employees with salary > 50,000:");
        highPaid.forEach(System.out::println);

        // Find highest paid employee
        Employee maxSalaryEmp = employees.stream()
                                         .max(Comparator.comparingDouble(Employee::getSalary))
                                         .orElse(null);

        System.out.println("\nHighest Paid Employee: " + maxSalaryEmp);
    }
}
