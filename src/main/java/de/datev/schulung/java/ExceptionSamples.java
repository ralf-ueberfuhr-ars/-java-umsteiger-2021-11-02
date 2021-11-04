package de.datev.schulung.java;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class ExceptionSamples {

    private static void fahre() throws LinienEndeException {
        // ..
        throw new LinienEndeException();
    }

    private static void sayHello(Person p) {
        if (null == p) {
            throw new IllegalArgumentException("p must not be null");
        }
        // oder: Optional.of(p);
        // oder:
        Objects.requireNonNull(p); // wirft NPE
        p.sayHello();
    }

    private static String readDbConnectionString() throws IOException {
        // lesen aus einer Properties-Datei
        // bis Java 6
        /*InputStream in = ExceptionSamples.class.getResourceAsStream("/db.properties");
        try {

        } finally {
            in.close();
        }*/
        // seit Java7: try~with~resources
        Properties p = new Properties();
        try(InputStream in = ExceptionSamples.class.getResourceAsStream("/db.properties")) {
            p.load(in);
        }
        return p.getProperty("db.url");
    }
    private static String readDbConnectionStringFromSystemProperty() {
        return System.getProperty("db.url"); // JVM-Start mit java -Ddb.url=....
    }

    public static void main(String[] args) {
        try {
            //sayHello(null);
            //} catch(Throwable t) { // NICHT machen!
        } catch (RuntimeException e) {
            throw e;
        // } catch(IOException | SQLException e) {
            // ...
        } catch (Exception e) { // NICHT machen!
            // alternativ:
            /*if(e instanceof  RuntimeException) {
                throw e;
            }*/
            e.printStackTrace();
        }
        Verkehrsmittel v = new Taxi();
        try {
            v.fahre();
        } catch (VerkehrmittelException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(readDbConnectionString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
