package edu.ashish.java8practice.methodreferences;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestBoundMethodReferences {

    public static void main(String[] args) {

        String name = "Mr. Ashish";

        Supplier<String> supplierLambda = () -> name.toLowerCase();
        // In below line, supplier bounds to name variable, hence it's a bound method reference.
        Supplier<String> supplierMR = name::toLowerCase;

        System.out.println(supplierLambda.get());
        System.out.println(supplierMR.get());


        Predicate<String> titleLambda = title -> name.startsWith(title);
        // startsWith is overloaded method, boolean startsWith(string) & boolean startsWith(string, int),
        // we are creating a Predicate which has a functional method of test(T), which gets fit with startswith(string)
        // This is where "context" is important for any lambda method to get converted to method reference.
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleLambda.test("Mr."));
        System.out.println(titleMR.test("Ms."));



    }
}
