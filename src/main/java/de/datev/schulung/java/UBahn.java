package de.datev.schulung.java;

public class UBahn implements Verkehrsmittel {
    @Override
    public void fahre() throws VerkehrmittelException {
        throw new LinienEndeException();
    }

    @Override
    public void fahreOhneException() {
        throw new RuntimeException(new LinienEndeException());
    }
}
