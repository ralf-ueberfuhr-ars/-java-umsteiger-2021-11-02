package de.datev.schulung.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationSample {

    // Mini-Framework, das die @Loggable-Annotation verwertet

    public static void main(String[] args) {
        auswerten(Kartenfarbe.class);
    }

    private static void auswerten(Class<?> c) {
        for(Method m : c.getDeclaredMethods()) {
            Loggable annotation = m.getAnnotation(Loggable.class);
            if(null != annotation) {
                System.out.println(m.getName() + " - " + annotation.value());
            }
        }
        for(Field f : c.getDeclaredFields()) {
            Loggable annotation = f.getAnnotation(Loggable.class);
            if(null != annotation) {
                System.out.println(f.getName() + " - " + annotation.value());
            }
        }
    }

}
