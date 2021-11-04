package de.datev.schulung.bank;

import de.datev.schulung.java.Person;

public class Konto {

    private Person inhaber;
    private double stand;

    public Person getInhaber() {
        return inhaber;
    }

    public void setInhaber(Person inhaber) {
        this.inhaber = inhaber;
    }

    public double getStand() {
        return stand;
    }

    public void setStand(double stand) {
        this.stand = stand;
    }

    public String sayHello() {
        if(inhaber == null) {
            throw new IllegalStateException("inhaber must not be null");
        }
        return inhaber.sayHello() + " (Stand: " + getStand() + ")";
    }

}
