package de.datev.schulung.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Min;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
@Validated
public class PersonenController {

    //@Autowired
    private final PersonenService service;

    @GetMapping(value = "personen", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Person> getPersonen() {
        return service.getAll();
    }

    @GetMapping(value="personen/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person getPerson(@Min(0) @PathVariable int index) {
        return service.get(index);
    }

}
