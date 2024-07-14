package edu.ashish.java8practice.methodreferences;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class TestStaticMethodReferences {

    public static void main(String[] args) {
        // Static method references are also unbound method references. An example of static method references
        // is Collections.sort(List). Note that, consumer takes one parameter => sort(List) is used, as
        // opposed to sort(List, Comparator). If overloaded method is used, then method reference can't be
        // used as comparator can't be passed in context

        Consumer<List<Integer>> sortLambda = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> numbers = Arrays.asList(6, 3, 13, 79, 5, 1);
        sortLambda.accept(numbers);
        System.out.println(numbers);

        numbers = Arrays.asList(5, 75, 23, 41, 9, 33);
        sortMR.accept(numbers);
        System.out.println(numbers);




    }
}
