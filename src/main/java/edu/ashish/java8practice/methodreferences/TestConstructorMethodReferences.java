package edu.ashish.java8practice.methodreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestConstructorMethodReferences {

    public static void main(String[] args) {

        // Constructor method reference is used to create objects using constructor.
        Supplier<StringBuilder> sbLambda = () -> new StringBuilder();
        Supplier<StringBuilder> sbMR = StringBuilder::new;

        StringBuilder sb1 = sbLambda.get();
        sb1.append("lambda version");
        System.out.println(sb1);

        StringBuilder sb2 = sbMR.get();
        sb2.append("method reference version");
        System.out.println(sb2);


        // The below lines show how to invoke a parameterized constructor using lambda/method reference
        Function<Integer, List<String>> alLambda = x -> new ArrayList<>(x);
        Function<Integer, List<String>> alMR = ArrayList::new;

        List<String> ls1 = alLambda.apply(10);
        ls1.add("21");
        System.out.println(ls1);

        List<String> ls2 = alMR.apply(7);
        ls2.add("30");
        System.out.println(ls2);

    }
}
