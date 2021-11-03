import de.datev.schulung.java.Person;

public class HalloWelt {

    final static int STANDARD_KAPAZITAET = 100;

    public static void main(final String[] args) {
        System.out.println("HalloWelt");
        System.out.printf("Hallo %s %s", "Welt", "!");

        // Wertetypen == primitiven Datentypen (Schlüsselwort, kleingeschrieben, keine Methoden)
        @SuppressWarnings("unsed")
        double d = 3.5;
        float f = 3.5F;
        long l = 5L;
        int i = 5;
        short s = 5;
        byte b = 5;
        char c = 'c'; // <int
        boolean bool = true;
        // alternative Schreibweisen
        i = 0x5A; // hex
        i = 0b010_0101_0110; // binär
        i = 050; // oktal
        bool = i == 40; // true
        i = Integer.parseInt("050");
        c = '\t'; // Tab-Zeichen
        c = '\n'; // Zeilenumbruch
        c = '\\'; // \
        c = '\u0040'; // Unicode
        c = 50; // Unicode
        i = 'c'; // Unicode
        // Vergleiche immer mit == oder !=

        // Referenztypen (Großschreibung, z.B. "String")
        // Wrappertypen (Boxing/Unboxing)
        Integer ii = i; // ii = Integer.valueOf(i);
        ii = null;
        i = ii;  // i = ii.intValue(); -> NPE
        // String, Wrappertypen sind immutable

        Person p = new Person();
        p.setAge(50);
        ändereAlter(p.getAge());

        // == ist Vergleich der Referenz (bei primitiv: Vergleich des Wertes)
        // Strings immer mit .equals() vergleichen
        String text = "abc";
        bool = text.equals("abc");
        bool = null != text && text.equals("abc");
        bool = "abc".equals(text);

    }

    private static void ändereAlter(int i) { // Call-by-Value
        i = 3;
    }

}
