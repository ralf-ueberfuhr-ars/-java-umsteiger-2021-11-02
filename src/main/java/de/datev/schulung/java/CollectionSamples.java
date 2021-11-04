package de.datev.schulung.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionSamples {

    private static <T extends Comparable<T>> T max(T t1, T t2) {
        return t1.compareTo(t2) > 0 ? t1 : t2;
    }

    // PECS (Producer Extends, Consumer super)
    private static <T> void add(Collection<T> col, T t) {
        col.add(t);
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
        for (Iterator<String> it = namen.iterator(); it.hasNext();) {
            String name = it.next();
            if(name.length()<3) {
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

        Collection namenRaw = namen;
        namenRaw.add(5);
        for (String name: namen) { // ClassCastException
            System.out.println(name);
        }



    }

}
