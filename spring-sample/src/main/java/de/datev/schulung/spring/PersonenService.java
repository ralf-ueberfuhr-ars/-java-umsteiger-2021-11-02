package de.datev.schulung.spring;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service // Middle Tier / Business Logic
@Validated
public class PersonenService {

    private List<Person> personen = new LinkedList<>();

    @PostConstruct
    public void init() {
        personen.add(new Person("Tom", 40));
        personen.add(new Person("Julia", 25));
    }

    public void add(@Valid Person person) {
        personen.add(person);
    }

    public void remove(Person person) {
        personen.remove(person);
    }

    public Collection<Person> getAll() {
        return personen;
    }

    public Person get(int index) {
        return personen.get(index);
    }

}
