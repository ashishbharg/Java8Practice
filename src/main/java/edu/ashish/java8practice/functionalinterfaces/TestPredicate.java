package edu.ashish.java8practice.functionalinterfaces;

import java.util.function.Predicate;

public class TestPredicate {

    public static void main(String[] args) {

        // Predicate takes one parameter and returns boolean

        System.out.println("String Predicate");
        Predicate<String> stringPredicate = s -> s.contains("ish");
        System.out.println(stringPredicate.test("My name is Ashish"));
        System.out.println(stringPredicate.test("My name is Ash"));

        System.out.println("Integer Predicate");
        Predicate<Integer> integerPredicate = n -> n > 10;
        System.out.println(integerPredicate.test(5));
        System.out.println(integerPredicate.test(20));
    }
}
