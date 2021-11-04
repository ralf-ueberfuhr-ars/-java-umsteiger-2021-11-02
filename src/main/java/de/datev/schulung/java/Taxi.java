package de.datev.schulung.java;

public class Taxi implements Verkehrsmittel {

    @Override
    public void fahre() throws VerkehrmittelException {
        // Exception muss nicht geworfen werden
    }

    @Override
    public void fahreOhneException() {

    }

}
