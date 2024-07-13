package edu.ashish.java8practice.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer{

    public static void main(String[] args) {

        // Consumer<T> takes an argument of type T but doesn't return anything back.
        Consumer<String> consumer = s -> System.out.println("Hello " + s);
        consumer.accept("Ash");

        List<String> names = new ArrayList<>();
        names.add("Ashish");
        names.add("Ash");
        names.add("Ashu");
        System.out.println("Java built in consumer");
        names.forEach(System.out::println); // Usage of consumer, forEach takes consumer as an argument
        System.out.println("Custom Consumer");
        names.forEach(consumer); // We can pass custom consumer to List forEach method
    }
}
