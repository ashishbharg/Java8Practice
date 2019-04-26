package edu.ashish.java8practice.streams;

import edu.ashish.java8practice.model.Employee;
import edu.ashish.java8practice.util.EmployeeListGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamsMaxTest {

    private static final List<Employee> employeeList = EmployeeListGenerator.getEmployees();


    public void testMaxSalaryOfEmployeesv1() {

        double salary = employeeList.stream().map(e -> e.getSalary()).mapToDouble(s -> s).max().getAsDouble();
        System.out.println("Max salary: " + salary);

    }

    public void testMaxSalaryOfEmployeesv2() {

        double salary = employeeList.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
        System.out.println("Max salary: " + salary);

    }

    public void testMaxSalaryOfEmployeesv3() {

        double salary = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).map(employee -> employee.getSalary()).orElseThrow(NoSuchElementException::new);
        System.out.println("Max salary: " + salary);

    }

    public void testMaxSalaryOfEmployeesv4() {

        double salary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getMax();
        System.out.println("Max salary: " + salary);

    }

    public static void main(String[] args) {

        StreamsMaxTest test = new StreamsMaxTest();
        test.testMaxSalaryOfEmployeesv1();
        test.testMaxSalaryOfEmployeesv2();
        test.testMaxSalaryOfEmployeesv3();
        test.testMaxSalaryOfEmployeesv4();

    }
}
