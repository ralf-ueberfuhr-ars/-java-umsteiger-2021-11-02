package de.datev.schulung.java;

import java.util.Collection;

public interface Fahrzeug {

    void fahre(); // public

    default void doFahren() {
        this.fahre();
    }

}
