package edu.ashish.java8practice.methodreferences;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestUnboundMethodReferences {

    public static void main(String[] args) {
        Function<String, String> upperLambda = s -> s.toUpperCase();
        // In below line, the method reference is not bounded to any variable. The parameter would be
        // passed during calling of this Function, hence it's unbounded
        Function<String, String> upperMR = String::toUpperCase;

        System.out.println(upperLambda.apply("Ashish"));
        System.out.println(upperMR.apply("Ashish"));

        BiFunction<String, String, String> concatLambda = (s1, s2) -> s1.concat(s2);
        // Similarly, while calling the function, actual instances would be passed, hence it's unbounded.
        BiFunction<String, String, String> concatMR = String::concat;

        System.out.println(concatLambda.apply("Ashish ", "Bhargava"));
        System.out.println(concatMR.apply("Ashish ", "Bhargava"));
    }
}
