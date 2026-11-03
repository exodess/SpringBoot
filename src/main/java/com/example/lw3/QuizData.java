package com.example.lw3;

import java.util.List;

public class QuizData {
    public QuizData(int id, String title, String question, List<String> answers) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answers = answers;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getQuestion() { return question; }
    public List<String> getAnswers() { return answers; }

    final private int id;
    final private String title;
    final private String question;
    final private List<String> answers;
}
