package de.datev.schulung.spring;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Person {

    @NotNull
    private String name;
    @Max(value = 80, message = "nicht zu alt")
    private int age;

}
