package com.atikash.rest.webservices.todoapplicationrest.services;

import com.atikash.rest.webservices.todoapplicationrest.todo.Todo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "atikash", "learn angular", new Date(), false));
        todos.add(new Todo(++idCounter, "atikash", "learn spring boot", new Date(), false));
        todos.add(new Todo(++idCounter, "atikash", "learn full stack development", new Date(), false));
        todos.add(new Todo(++idCounter, "atikashSingh", "learn full stack development12", new Date(), false));

    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        todos.remove(todo);
        return todo;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id)
                return todo;
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}


