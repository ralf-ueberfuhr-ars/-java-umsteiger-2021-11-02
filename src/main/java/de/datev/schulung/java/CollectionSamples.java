package de.datev.schulung.java;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionSamples {

    private static <T extends Comparable<T>> T max(T t1, T t2) {
        return t1.compareTo(t2) > 0 ? t1 : t2;
    }

    private static <T> void add(Collection<T> col, T t) {
        col.add(t);
    }

    // PECS (Producer Extends, Consumer super)
    private static double average(Collection<? extends Number> numbers) {
        double result = 0;
        int count = 0;
        for (Number n : numbers) { // Collection ist Lieferant (Producer)
            result += n.doubleValue();
            count++;
        }
        // numbers.add(Integer.valueOf(5)); -> das geht hier nicht!
        return result;
    }

    private static void fillNumbers(Collection<? super Number> numbers) {
        for (int i = 0; i < 100; i++) {
            numbers.add(Math.random()); // Collection ist Empfänger (Consumer)
        }
        // Object o = numbers.iterator().next(); -> Auslesen nur als Object
    }

    public static void main(String[] args) {
        Collection<String> namen = new HashSet<>();
        namen.add("Tom");
        namen.add("Julia");
        add(namen, "Joseph");
        //namen = Arrays.asList("Tom", "Julia"); // List: Duplikate/Reihenfolge
        for (String name : namen) {
            System.out.println(name);
            // namen.remove(name); -> Exception
        }
        for (Iterator<String> it = namen.iterator(); it.hasNext(); ) {
            String name = it.next();
            if (name.length() < 3) {
                it.remove();
                // namen.remove(name); -> Exception
            }
        }
        namen.forEach(name -> System.out.println(name));

        Collection<Number> zahlen = new HashSet<>();
        zahlen.add(5); // Autoboxing
        zahlen.add(5.5); // Autoboxing
        add(zahlen, 4);
        Collection<Object> alles = new HashSet<>();
        add(alles, 4);

        // Generische Typen sind Geschwisterklassen
        // Gemeinsame Oberklasse ist der Raw Type
        //alles = zahlen;
        Collection col = alles;
        col = zahlen;

        try {
            Collection namenRaw = namen;
            namenRaw.add(5);
            for (String name : namen) { // ClassCastException
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //PECS
        System.out.println(average(Arrays.asList(1, 3, 5, 10)));
        System.out.println(average(zahlen));
        Collection<Double> doubleZahlen = Arrays.asList(4.5, 0.3, -3.4);
        System.out.println(average(doubleZahlen));

        Collection<Object> alleObjekte = new LinkedList<>();
        alleObjekte.add("Tom");
        alleObjekte.add(4);
        alleObjekte.add(LocalDate.now());
        fillNumbers(alleObjekte);
        System.out.println(alleObjekte);
    }

}
