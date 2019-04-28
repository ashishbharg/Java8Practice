package edu.ashish.java8practice.streams;

import edu.ashish.java8practice.model.Department;
import edu.ashish.java8practice.model.Employee;
import edu.ashish.java8practice.util.EmployeeListGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsMapCollectorTest {

    private static final List<Employee> employeeList = EmployeeListGenerator.getEmployees();


    // Collectors.toMap() should only be used when there are no duplicate keys,
    // else IllegalStateException will come stating Duplicate Key Present.
    /*public void testGroupByDepartmentId() {

        Map<Department, Employee> map = employeeList.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity()));
        System.out.println("Max salary: " + map);
    }*/

    public void testGroupByDepartmentIdv2() {

        Map<Department, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees grouped by department: " + map);
        printMap(map);
    }

    public static void main(String[] args) {

        StreamsMapCollectorTest test = new StreamsMapCollectorTest();
//        test.testGroupByDepartmentId();
        test.testGroupByDepartmentIdv2();
    }

    public static void printMap(Map<Department, List<Employee>> map) {

        Set<Map.Entry<Department, List<Employee>>> entries = map.entrySet();
        Iterator<Map.Entry<Department, List<Employee>>> iterator = entries.iterator();
        String key;
        Map.Entry<Department, List<Employee>> entry;
        while(iterator.hasNext()) {
            entry = iterator.next();
            key = entry.getKey().getDepartmentId();
            List<Employee> employees = entry.getValue();

            System.out.println("Department ID: " + key + ", Employees: " + employees);
        }

    }
}
