package de.datev.schulung.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Person p = new Person();
        //p.setAge(30);

        Class<?> personClass = Class.forName("de.datev.schulung.java.Person");
        Object p = personClass.getDeclaredConstructor().newInstance();
        Method setAgeMethod = personClass.getDeclaredMethod("setAge", Integer.TYPE);
        setAgeMethod.invoke(p, 30);
        System.out.println(p);

    }

}
