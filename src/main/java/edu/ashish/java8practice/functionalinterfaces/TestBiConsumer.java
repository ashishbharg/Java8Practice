package edu.ashish.java8practice.functionalinterfaces;

import edu.ashish.java8practice.model.Employee;
import edu.ashish.java8practice.util.EmployeeListGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestBiConsumer {

    public static void main(String[] args) {

        // BiConsumer<T,U> takes two arguments of types <T> and <U> but doesn't return anything back.

        System.out.println("BiConsumer with Simple Datatype");
        BiConsumer<String, String> biConsumer = (fName, lName) -> System.out.println("Hello " + fName + " " + lName);
        biConsumer.accept("Ashish", "Bhargava");

        System.out.println();
        System.out.println("BiConsumer with Custom Datatype");
        BiConsumer<String, Double> empConsumer = (name, salary) -> System.out.println("Employee name: " + name + " has salary $" + salary);
        List<Employee> employees = EmployeeListGenerator.getEmployees();
        employees.forEach(employee -> empConsumer.accept(employee.getName(), employee.getSalary()));

        System.out.println();
        System.out.println("BiConsumer with HashMap");
        Map<String, String> mapCapitalCities = new HashMap<>();
        BiConsumer<String, String> mapBiConsumer = (key, value) -> mapCapitalCities.put(key, value);
        mapBiConsumer.accept("India", "New Delhi");
        mapBiConsumer.accept("USA", "Washington D.C.");
        mapBiConsumer.accept("Ireland", "Dublin");
        System.out.println("Printing Countries with it's capital from map");
        System.out.println(mapCapitalCities);
        BiConsumer<String, String> mapCapitalCitiesPrint = (key, value) -> System.out.println(value + " is capital of " + key);
        mapCapitalCities.forEach(mapCapitalCitiesPrint);


    }
}
