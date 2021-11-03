package de.datev.schulung.java;

import java.util.Map;

public class GeometrischeFigur {

    // Koordinaten bestehen aus X/Y
    private Coordinate[] punkte = new Coordinate[3];

    public static void main(String[] args) {
        // static: keine Instanz von GeometrischeFigur notwendig
        GeometrischeFigur.Coordinate coord = new GeometrischeFigur.Coordinate(3,4);
        // nopn-static: Instanz der GeometrischeFigur ist notwendig
        GeometrischeFigur f = new GeometrischeFigur();
        NonStaticCoordinate coord2 = f.new NonStaticCoordinate();
    }


    public class NonStaticCoordinate {

    }

    public static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate() {
            this(4,4);
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void doSth() {
            // geht bei static nicht
            // System.out.println(punkte.length);
        }

    }

    public Coordinate getFirstPoint() {
        return punkte[0];
    }

}
