package edu.ashish.java8practice.functionalinterfaces;

import java.util.function.Function;

public class TestFunction {

    public static void main(String[] args) {

        // Function<T,R> takes T as input argument and returns R type

        Function<String, Integer> function = s -> s.length(); // Function takes in string and returns integer
        System.out.println(function.apply("Ashish"));

        Function<Integer, Integer> mathFunction = n -> (int)Math.pow(n, 2);
        System.out.println(mathFunction.apply(5));
    }
}
