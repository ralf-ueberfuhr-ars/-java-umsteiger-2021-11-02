package de.datev.schulung.nahverkehr;

import de.datev.schulung.java.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Stream;

public class Haltestelle {

    private Collection<Person> wartende = new HashSet<>();

    /**
     *
     * @return unmodifiable collection of wartende
     */
    public Stream<Person> getWartende() {
        // return new HashSet<>(wartende); Kopier herausgeben
        // return Collections.unmodifiableCollection(wartende); // Wrapper mit Exceptions
        return wartende.stream();
    }


}
