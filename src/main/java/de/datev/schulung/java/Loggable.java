package de.datev.schulung.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Markiert eine Methode, die auf der Konsole ausgegeben werden soll.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

    /*
     * in Java: eigene Annotationen schreiben für
     *  - Bean Validation API: Custom Constraints
     *  - Spring/JUnit (Test): mehrere Annotationen zusammenführen
     */

    /**
     * Ergänzung zur Ausgabe auf der Konsole
     */
    String value() default "";

}
