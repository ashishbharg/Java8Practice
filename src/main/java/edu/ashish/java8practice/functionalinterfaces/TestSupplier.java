package edu.ashish.java8practice.functionalinterfaces;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {

        // Supplier is a functional interface which takes no arguments but return the type that is declared.
        System.out.println("String Builder Supplier");
        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        System.out.println(supplier.get().append("Hello ").append("Ashish"));

        System.out.println("Local time supplier");
        Supplier<LocalTime> localTimeSupplier = () -> LocalTime.now();
        System.out.println(localTimeSupplier.get());

        System.out.println("Random Supplier");
        Supplier<Double> randomSupplier = () -> Math.random() * 10;
        System.out.println(randomSupplier.get());
    }
}
