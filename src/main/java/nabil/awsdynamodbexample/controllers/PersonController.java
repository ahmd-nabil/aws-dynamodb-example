package nabil.awsdynamodbexample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nabil.awsdynamodbexample.entities.Person;
import nabil.awsdynamodbexample.repos.PersonRepo;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable String personId) {
        return ResponseEntity.ok(personRepo.getPerson(personId));
    }

    @PostMapping
    public ResponseEntity<Void> savePerson(@RequestBody Person person) {
        personRepo.savePerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Void> updatePerson(@PathVariable String personId, @RequestBody Person person) {
        person.setPersonId(personId);
        personRepo.updatePerson(person);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable String personId) {
        personRepo.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }
}
