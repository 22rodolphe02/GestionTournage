package com.tournage.repository;

import com.tournage.models.Person;

public class PersonRepository extends RepositoryImpl<Person> {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        System.out.println(personRepository);
    }
}
