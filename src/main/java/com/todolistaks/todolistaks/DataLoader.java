package com.todolistaks.todolistaks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ToDoListRepository repository;

    @Override
    public void run(String... strings)throws Exception{
        ToDoList todolist = new ToDoList("Class", "Home Work");
        repository.save(todolist);
        todolist = new ToDoList("Bank", "Statement");
        repository.save(todolist);
    }
}
