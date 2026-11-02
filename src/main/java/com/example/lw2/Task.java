package com.example.lw2;

public class Task {
    private int id;
    private String name;
    private String description;
    private boolean completed;

    public Task() {}
    public Task(int id, String name, String description, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return completed;
    }
}