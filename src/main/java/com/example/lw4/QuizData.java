package com.example.lw4;

import java.util.List;

public class QuizData {
    QuizData(Quiz quiz) {
        this.id = quiz.getId();
        this.title = quiz.getTitle();
        this.question = quiz.getQuestion();
        this.answers = quiz.getAnswers();
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
