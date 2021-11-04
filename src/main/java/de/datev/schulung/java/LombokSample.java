package de.datev.schulung.java;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class LombokSample {


    //@Builder
    private static @Data class Person {

//        @Getter
//        @Setter
        private String name;

    }

    public static void main(String[] args) {

        Person p = new Person();
        p.setName("Tom");

        //Person p2 = Person.builder().name("Tom").build();

    }

}
