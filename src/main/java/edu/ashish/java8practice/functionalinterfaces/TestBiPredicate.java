package edu.ashish.java8practice.functionalinterfaces;

import java.util.function.BiPredicate;

public class TestBiPredicate {

    public static void main(String[] args) {

        // BiPredicate<T,U> takes two parameters of type <T> and <U> and returns boolean

        System.out.println("String BiPredicate");
        BiPredicate<String, Integer> stringPredicate = (s, len) -> s.length() == len;
        System.out.println(stringPredicate.test("My name is Ashish", 14));
        System.out.println(stringPredicate.test("My name is Ash", 14));

        System.out.println("Integer Predicate");
        BiPredicate<Integer, Integer> integerPredicate = (num1, num2) -> num1 > num2;
        System.out.println(integerPredicate.test(5, 8));
        System.out.println(integerPredicate.test(20, 10));
    }
}
