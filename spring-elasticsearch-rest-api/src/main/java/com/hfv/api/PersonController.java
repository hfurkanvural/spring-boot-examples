package com.hfv.api;

import com.hfv.entity.Person;
import com.hfv.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init()
    {
        Person p = new Person();
        p.setName("name");
        p.setSurname("surname");
        p.setAddress("address info");
        p.setId("P0001");
        personRepository.save(p);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search)
    {
        List<Person> people = personRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(people);
    }

}
