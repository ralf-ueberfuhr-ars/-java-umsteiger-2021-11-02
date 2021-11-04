package de.datev.schulung.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaDemo {

    // Summiere 2 Zahlen
    private static double summarize(double d1, double d2) {
        return d1 + d2;
    }

    // Erweiterung: Summiere Zahlen solange, bis die Summe > 1
    private static double summarize2(NumberGenerator generator) {
        double sum = 0;
        while (sum <= 1) {
            sum += generator.generate();
        }
        return sum;
    }

    // Funktionales Interface = Interface mit exakt 1 abstrakten Methode
    @FunctionalInterface
    private static interface NumberGenerator {
        double generate();
    }

    // Erweiterung: Wir verwenden Java-Standard-Interfaces
    private static double summarize3(Supplier<Double> generator) {
        double sum = 0;
        while (sum <= 1) {
            sum += generator.get();
        }
        return sum;
    }

    public static void main(String[] args) {
        // Immediate Evaluation
        System.out.println(summarize(3.5, 0.7));
        // ich möchte 2 Zufallszahlen summieren
        System.out.println(summarize(Math.random(), Math.random()));

        System.out.println(summarize2(new NumberGenerator() {
            @Override
            public double generate() {
                return Math.random();
            }
        }));

        // Lambdas
        System.out.println(summarize2(() -> {
            return Math.random();
        }));
        // Spezialfall: nur 1 Anweisung
        System.out.println(summarize2(() -> Math.random()));
        // Spezialfall: Parameter-Matching
        System.out.println(summarize2(Math::random)); // Method Reference Operator

        // Java-Standard-Interfaces
        System.out.println(summarize3(Math::random)); // Method Reference Operator

        Supplier<Double> supplier = Math::random;
        Double d = supplier.get();
        Supplier<Date> dateSupplier = () -> new Date();
        dateSupplier = Date::new;

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hallo Welt");
        consumer = System.out::println;

        Function<Integer, String> func = i -> Integer.toString(i);
        // func = Integer::toString; geht nicht, weil überladen

        Predicate<String> p = s -> s.length()==0;
        p = s -> s.isEmpty();
        p = String::isEmpty;

        // Streams

        Collection<String> namen = Arrays.asList("Tom", "Julia", "Maximilian", "Alexandra");
        // alle kurzen Namen (<=5) in Großbuchstaben
        Collection<String> neueNamen = namen.stream()
          .filter(s -> s.length()<=5)
          .map(String::toUpperCase)
          .collect(Collectors.toList());
        System.out.println(neueNamen);

        namen.forEach(System.out::println);

    }

}
