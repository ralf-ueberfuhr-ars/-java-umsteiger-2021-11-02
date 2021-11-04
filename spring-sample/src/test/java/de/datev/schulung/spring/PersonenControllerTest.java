package de.datev.schulung.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonenControllerTest {

    @Autowired
    PersonenController controller;
    @MockBean
    PersonenService service;

    @Test
    @Tag("integration-test")
    void testGetPersonen() {
        when(service.getAll()).thenReturn(Arrays.asList(new Person("",20)));
        Collection<Person> personen = controller.getPersonen();
        assertThat(personen).isNotEmpty();
    }

}
