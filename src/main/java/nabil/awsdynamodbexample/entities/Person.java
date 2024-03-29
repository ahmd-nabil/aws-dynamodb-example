package nabil.awsdynamodbexample.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "person")
public class Person {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String personId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private int age;

    @DynamoDBAttribute
    private Address address;

    public Person() {
    }

    public Person(String personId, String name, int age, Address address) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
