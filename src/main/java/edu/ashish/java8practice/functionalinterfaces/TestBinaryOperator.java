package edu.ashish.java8practice.functionalinterfaces;

import java.util.function.BinaryOperator;

public class TestBinaryOperator {

    public static void main(String[] args) {

        // BinaryOperator<T> extends BiFunction<T,T,T>. It differs from BiFunction by having same types <T>
        // for both input arguments and return type
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println(binaryOperator.apply("Ashish ", "Bhargava"));

        BinaryOperator<Integer> numBinaryOperator = (num1, num2) -> num1 + num2;
        System.out.println(numBinaryOperator.apply(5,7));
    }
}
