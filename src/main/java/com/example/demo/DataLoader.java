package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ToDoRepository todorepository;

    @Override
    public void run(String... strings) throws Exception{
        ToDo todo;
        todo = new ToDo("Buy Java Book by Kathy Sierra", LocalDate.parse("2020-10-09"),
                1, "Highly recommended for Java OCA Certification");
        todorepository.save(todo);

        todo = new ToDo("Finish Java Bootcamp", LocalDate.parse("2020-05-09"),
                2, "Gives Wonderful skill.");
        todorepository.save(todo);

        todo = new ToDo("Update my Resume", LocalDate.parse("2020-04-09"),
                3, "Use MC's online application");
        todorepository.save(todo);

    }
}
