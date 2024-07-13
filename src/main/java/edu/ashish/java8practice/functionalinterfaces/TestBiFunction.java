package edu.ashish.java8practice.functionalinterfaces;

import java.util.function.BiFunction;

public class TestBiFunction {

    public static void main(String[] args) {

        // Function<T,U,R> takes <T> and <U> as input arguments and returns R type

        BiFunction<String, String, Integer> function = (s1, s2) -> s1.length() + s2.length(); // Function takes in string and returns integer
        System.out.println(function.apply("Ashish", "Bhargava"));

        BiFunction<String, String, String> strConcatFunction = (s1, s2) -> s1.concat(s2);
        System.out.println(strConcatFunction.apply("Ashish ", "Bhargava"));
    }
}
