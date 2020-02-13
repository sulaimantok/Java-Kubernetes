package com.apicrud.java.kubernetes.Repository;

import org.springframework.data.repository.CrudRepository;

import com.apicrud.java.kubernetes.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}

