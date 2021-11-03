package de.datev.schulung.java;

@Deprecated // Annotation
public enum Kartenfarbe { // extends Enum<Kartenfarbe>

    // abgeschlossene Aufzählung: KARO=9, HERZ=10, PIK=11, KREUZ=12

    KARO(9), HERZ(10), PIK(11), KREUZ(12);

//    public static final Kartenfarbe KARO = new Kartenfarbe(9);
//    public static final Kartenfarbe HERZ = new Kartenfarbe(10);
//    public static final Kartenfarbe PIK = new Kartenfarbe(11);
//    public static final Kartenfarbe KREUZ = new Kartenfarbe(12);

    @Loggable(value = "Das ist Feld!")
    private final int wert;

    private Kartenfarbe(int wert) {
        this.wert = wert;
    }

    @Loggable
    public int getWert() {
        return wert;
    }

    public static void main(String[] args) {

        Kartenfarbe f = Kartenfarbe.HERZ;
        int wert = f.getWert();
        int ordinal = f.ordinal();
        String name = f.name();
        Kartenfarbe[] values = Kartenfarbe.values();
        if(f == Kartenfarbe.HERZ) {
            //  ...
        }
        switch (f) {
        case PIK: break;
        case HERZ: break;
        }

    }

}
