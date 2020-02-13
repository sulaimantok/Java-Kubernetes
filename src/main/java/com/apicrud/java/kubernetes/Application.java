package com.apicrud.java.kubernetes;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apicrud.java.kubernetes.Repository.PersonRepository;
import com.apicrud.java.kubernetes.model.Person;
import com.apicrud.java.kubernetes.service.PersonService;

@SpringBootApplication
public class Application {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void checkIfWorks() {

        repository.deleteAll();

        service.create(new Person("Minikube",
                LocalDate.of(2006, 10, 01)));
        service.create(new Person("Kubectl",
                LocalDate.of(1999, 05, 15)));

        List<Person> findAll = service.findAll();
        for (Person person : findAll) {
            System.out.println(person.getId() + ":" + person.getName());
        }

    }

}
