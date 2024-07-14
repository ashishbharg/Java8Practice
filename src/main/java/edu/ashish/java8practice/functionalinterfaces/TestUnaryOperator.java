package edu.ashish.java8practice.functionalinterfaces;

import java.util.function.UnaryOperator;

public class TestUnaryOperator {

    public static void main(String[] args) {

        // UnaryOperator<T> extends Function<T,R>. It differs from function by having just one type <T>
        // where input argument is <T> and return type is also <T>
        UnaryOperator<String> unaryOperator = s -> s.concat("!!!");
        System.out.println(unaryOperator.apply("Wow"));

        UnaryOperator<Integer> unaryOp = num -> num / 2;
        System.out.println(unaryOp.apply(9));
    }
}
