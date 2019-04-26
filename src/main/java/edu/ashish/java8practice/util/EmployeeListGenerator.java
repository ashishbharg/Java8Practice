package edu.ashish.java8practice.util;

import edu.ashish.java8practice.model.Department;
import edu.ashish.java8practice.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListGenerator {

    public static List<Employee> getEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        Employee emp1 = new Employee("Harry", 20000, new Department("1", "IT"));
        Employee emp2 = new Employee("Tim", 25000, new Department("1", "IT"));
        Employee emp3 = new Employee("Vince", 10000, new Department("2", "Finance"));
        Employee emp4 = new Employee("Ankit", 30000, new Department("3", "Management"));
        Employee emp5 = new Employee("Divya", 20000, new Department("1", "Finance"));
        Employee emp6 = new Employee("Jamie", 5000, new Department("1", "Security"));
        Employee emp7 = new Employee("John", 22000, new Department("1", "IT"));

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);

        return employeeList;
    }
}
