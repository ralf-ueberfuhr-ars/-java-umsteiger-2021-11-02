package de.datev.schulung.java;

import de.datev.schulung.bank.Konto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KontoTest {

    @Mock
    Person person;
    @InjectMocks
    Konto konto;

    @Test
    void testSayHello() {
        //person = Mockito.mock(Person.class); // lokaler Mock
        when(person.sayHello()).thenReturn("xyz");

        String result = konto.sayHello();
        // Assertions
        assertAll(
          () -> verify(person, never()).getAge(),
          () -> assertThat(result).isEqualTo("xyz (Stand: 0.0)")
        );

    }

    @Test
    void testIllegalStateExceptionIfInhaberEmpty() {
        konto.setInhaber(null);
        assertThrows(IllegalStateException.class, () -> konto.sayHello());
        assertThatThrownBy(() -> konto.sayHello())
          .isInstanceOf(IllegalStateException.class)
          .hasMessage("inhaber must not be null");
    }

}
