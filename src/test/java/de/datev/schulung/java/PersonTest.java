package de.datev.schulung.java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest { // Maven-Konvention *Test

    // sayHello testen
    // 1) name = "Max"
    // 2) name = null

    @Test
    void testSayHelloWithMax() {
        // Arrange
        Person p = new Person();
        p.setName("Max");
        // Act
        String result = p.sayHello();
        // Assert - JUnit
        assertEquals("Hello! My name is Max", result);
        // Assert - AssertJ (https://assertj.github.io/doc/)
        assertThat(result).isEqualTo("Hello! My name is Max");
    }


}
