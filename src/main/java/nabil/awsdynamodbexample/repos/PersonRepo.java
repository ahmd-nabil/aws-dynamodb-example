package nabil.awsdynamodbexample.repos;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import nabil.awsdynamodbexample.entities.Person;

@Repository
public class PersonRepo {
    private final DynamoDBMapper mapper;

    public PersonRepo(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public void savePerson(Person person) {
        mapper.save(person);
    }

    public Person getPerson(String personId) {
        return mapper.load(Person.class, personId);
    }

    public void updatePerson(Person person) {
        mapper.save(person);
    }

    public void deletePerson(String personId) {
        Person toDelete = mapper.load(Person.class, personId);
        mapper.delete(toDelete);
    }
}
