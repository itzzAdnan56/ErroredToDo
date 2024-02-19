package com.webtodo.WebToDo.Controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        todos.add(
                new ToDo(
                        ++todoCount,
                        "Adnan1",
                        "Learn Spring",
                        java.time.LocalDate.now(),
                        false));
        todos.add(
                new ToDo(
                        ++todoCount,
                        "Adnan1",
                        "Learn Spring MVC",
                        java.time.LocalDate.now(),
                        false));
        todos.add(
                new ToDo(
                        ++todoCount,
                        "Adnan2",
                        "Learn to Dance",
                        java.time.LocalDate.now(),
                        false));
    }

    public List<ToDo> findByUserName(String userName) {
        Predicate<? super ToDo> predicate = todo -> todo.getUserName() != null && todo.getUserName().equalsIgnoreCase(userName);
        return todos.stream().filter(predicate).toList();
    }

    public static void AddToDo(String userName, String description, LocalDate targetDate, boolean isDone) {
        ToDo newToDo = new ToDo(++todoCount, userName, description, targetDate, isDone);
        todos.add(newToDo);
    }

    public static void DeleteToDoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public static ToDo FindToDoById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        ToDo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public static void UpdateToDo(@Valid ToDo todo){
        DeleteToDoById(todo.getId());
        todos.add(todo);
    }
}

