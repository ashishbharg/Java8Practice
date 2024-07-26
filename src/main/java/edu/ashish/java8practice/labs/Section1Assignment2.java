package edu.ashish.java8practice.labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Section1Assignment2 {

    public static void main(String[] args) {

        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }

    private static void staticMR() {
        List<Integer> numbers = Arrays.asList(1,2,7,4,5);
        System.out.println("Before Lambda sorting: " + numbers);
        Consumer<List<Integer>> consumerLambda = (list) -> Collections.sort(list);
        consumerLambda.accept(numbers);
        System.out.println("After Lambda sorting: " + numbers);

        numbers = Arrays.asList(1,2,7,4,5);
        System.out.println("Before MR sorting: " + numbers);
        Consumer<List<Integer>> consumerMR = Collections::sort;
        consumerMR.accept(numbers);
        System.out.println("After MR sorting: " + numbers);


    }

    private static void boundMR() {

        String name = "Mr. Joe Bloggs";

        Predicate<String> predicateLambda = prefix -> name.startsWith(prefix);
        System.out.println(predicateLambda.test("Mr."));
        System.out.println(predicateLambda.test("Ms."));

        Predicate<String> predicateMR = name::startsWith;
        System.out.println(predicateMR.test("Mr."));
        System.out.println(predicateMR.test("Ms."));
    }

    private static void unboundMR() {

        Predicate<String> predicateLambda = str -> str.isEmpty();
        System.out.println(predicateLambda.test(""));
        System.out.println(predicateLambda.test("xyz"));

        Predicate<String> predicateMR = String::isEmpty;
        System.out.println(predicateMR.test(""));
        System.out.println(predicateMR.test("xyz"));

        BiPredicate<String, String> biPredicateLambda = (str, prefix) -> str.startsWith(prefix);
        System.out.println(biPredicateLambda.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicateLambda.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> biPredicateMR = String::startsWith;
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms."));

    }

    private static void constructorMR() {

        Supplier<List<String>> supplierLambda = () -> new ArrayList<>();
        List<String> list = supplierLambda.get();
        list.add("Lambda");
        System.out.println(list);

        Supplier<List<String>> supplierMR = ArrayList::new;
        list = supplierMR.get();
        list.add("Method Reference");
        System.out.println(list);

        Function<Integer, List<String>> functionLambda = capacity -> new ArrayList<>(capacity);
        List<String> functionList = functionLambda.apply(10);
        functionList.add("Lambda");
        System.out.println(functionList);

        Function<Integer, List<String>> functionMR = ArrayList::new;
        functionList = functionMR.apply(10);
        functionList.add("Method Reference");
        System.out.println(functionList);

    }
}
