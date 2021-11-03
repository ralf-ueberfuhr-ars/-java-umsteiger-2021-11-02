package de.datev.schulung.java;

import de.datev.schulung.bank.Konto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        verify(person, never()).getAge();

    }

}
