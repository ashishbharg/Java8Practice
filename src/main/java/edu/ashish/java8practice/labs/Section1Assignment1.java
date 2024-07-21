package edu.ashish.java8practice.labs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable<T> {
    void print(T t);
}

interface Retrievable<T> {
    T retrieve();
}

interface Evaluate<T> {
    boolean isNegative(T t);
}

interface PredicateEvaluate<T> {
    boolean check(T t, Predicate<T> predicate);
}

interface Functionable<T,R> {
    R applyThis(T t);
}

class Person {
    Integer age;

    String name;

    Double height;

    public Person(Integer age, String name, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public Double getHeight() {
        return this.height;
    }

    public String toString() {
        return this.name + ", " + this.age + ", " + this.height;
    }
}

public class Section1Assignment1 {

    public static void main(String[] args) {

        System.out.println("Testing Consumer");
        consumer();

        System.out.println("Testing Supplier");
        supplier();

        System.out.println("Testing Predicate");
        predicate();

        System.out.println("Testing Function");
        function();

        System.out.println("Testing sort by age");
        List<Person> people = getPeople();
        sortByAge(people);
        people.forEach(person -> System.out.println(person.getName() + " -> " + person.getAge()));
        people.forEach(System.out::println);

        System.out.println("Testing sort by name");
        people = getPeople();
        sortByName(people);
        people.forEach(person -> System.out.println(person.getName()));
        people.forEach(System.out::println);

        System.out.println("Testing sort by height");
        people = getPeople();
        sortByHeight(people);
        people.forEach(person -> System.out.println(person.getName() + " -> " + person.getHeight()));
        people.forEach(System.out::println);
    }

    private static void consumer() {
        // 1a
        Printable<String> printableLambda = s -> System.out.println(s);
        printableLambda.print("Printable lambda");

        //1b
        Consumer<String> consumerLambda = System.out::println;
        consumerLambda.accept("Printing lambda via consumer");

        Consumer<String> consumerMR = System.out::println;
        consumerMR.accept("Printing method reference via consumer");
    }

    private static void supplier() {

        //2a
        Retrievable<Integer> intRetrievable = () -> 77;
        System.out.println(intRetrievable.retrieve());

        //2b
        Supplier<Integer> intSupplier = () -> 77;
        System.out.println(intSupplier.get());
    }

    private static void predicate(){

        //3a
        Evaluate<Integer> intEvaluate = num -> num < 0;
        System.out.println(intEvaluate.isNegative(-1));
        System.out.println(intEvaluate.isNegative(1));

        //3b
        Predicate<Integer> intPredicate = num -> num < 0;
        System.out.println(intPredicate.test(-1));
        System.out.println(intPredicate.test(1));

        //3c
        PredicateEvaluate<Integer> oddEvenNumberEvaluate = (num, p) -> p.test(num);
        System.out.println(oddEvenNumberEvaluate.check(4, num -> num % 2 == 0));
        System.out.println(oddEvenNumberEvaluate.check(7, num -> num % 2 == 0));

        PredicateEvaluate<String> titleEvaluate = (s, p) -> p.test(s);
        System.out.println(titleEvaluate.check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));
        System.out.println(titleEvaluate.check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));

        PredicateEvaluate<Person> ageEvaluate = (person, predicate) -> predicate.test(person);
        Person person = new Person(33, "Mike", 1.8);
        System.out.println(ageEvaluate.check(person, per -> per.getAge() >= 18));
        person = new Person(13, "Ann", 1.4);
        System.out.println(ageEvaluate.check(person, per -> per.getAge() >= 18));
    }

    private static void function() {

        Functionable<Integer, String> functionable = (num) -> "Number is: " + num;
        System.out.println(functionable.applyThis(25));

        Function<Integer, String> function = (num) -> "Number is: " + num;
        System.out.println(function.apply(25));
    }

    private static List<Person> getPeople() {

        List<Person> result = new ArrayList<>();
        result.add(new Person(33,"Mike", 1.8));
        result.add(new Person(25,"Mary", 1.4));
        result.add(new Person(34,"Alan", 1.7));
        result.add(new Person(30,"Zoe", 1.5));
        return result;
    }

    private static void sortByAge(List<Person> people) {
        people.sort(Comparator.comparing(person -> person.getAge(), (p1, p2) -> p1 - p2));
    }

    private static void sortByName(List<Person> people) {
        people.sort(Comparator.comparing(person -> person.getName(), (p1, p2) -> p1.compareTo(p2)));
    }

    private static void sortByHeight(List<Person> people) {
        people.sort(Comparator.comparing(person -> person.getHeight(), (p1, p2) -> Double.compare(p1, p2)));
    }

}
