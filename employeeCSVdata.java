import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class employeeCSVdata {

    public static void main(String[] args) {
        // Task 1: Data Generation
        List<Employee> employees = generateEmployeeData();

        // Task 2: CSV File Writing
        writeDataToCSV(employees);

        // Task 3: CSV File Verification
        verifyCSVFile();

        System.out.println("Program executed successfully.");
    }

    private static List<Employee> generateEmployeeData() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "John Doe", "IT", 60000.0));
        employees.add(new Employee(2, "Jane Smith", "HR", 55000.0));
        employees.add(new Employee(3, "Bob Johnson", "Finance", 70000.0));
        employees.add(new Employee(4, "Alice Brown", "Marketing", 50000.0));
        employees.add(new Employee(5, "Charlie Davis", "Operations", 65000.0));

        return employees;
    }

    private static void writeDataToCSV(List<Employee> employees) {
        String csvFileName = "output.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFileName))) {
            // Task 2.1: Write header row
            writer.println("Employee ID,Employee Name,Department,Salary");

            // Task 2.2: Iterate through the data structure
            for (Employee employee : employees) {
                // Task 2.3: Write a new row to the CSV file
                writer.println(employee.toCSVString());
            }

        } catch (IOException e) {
            // Task 4: Handling Exceptions
            e.printStackTrace();
        }
    }

    private static void verifyCSVFile() {
        String csvFileName = "output.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
            // Task 3.1: Read the contents of the CSV file
            String line;
            while ((line = reader.readLine()) != null) {
                // Task 3.2: Display the contents on the console
                System.out.println(line);
            }

        } catch (IOException e) {
            // Task 4: Handling Exceptions
            e.printStackTrace();
        }
    }

    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String toCSVString() {
            return id + "," + name + "," + department + "," + salary;
        }
    }
}
