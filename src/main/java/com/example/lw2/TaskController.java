package com.example.lw2;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {
    private final List<Task> taskList = List.of(
            new Task(1, "task1", "A first test task", false),
            new Task(2, "task2", "A second test task", true)
    );

    @GetMapping("/getOne")
    public int returnOne() {
        return 1;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskList;
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return taskList.get(id - 1); // list indices start from 0
    }
}