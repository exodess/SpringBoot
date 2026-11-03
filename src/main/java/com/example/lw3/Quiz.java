package com.example.lw3;

import java.util.List;

public class Quiz {
    public Quiz(String title, String question, List<String> answers, int correct_answer) {
        this.title = title;
        this.question = question;
        this.answers = answers;
        this.correct_answer = correct_answer;
    }

    public String getTitle() { return title; }
    public String getQuestion() { return question; }
    public List<String> getAnswers() { return answers; }
    public int getCorrectAnswer() { return correct_answer; }

    final private String title;
    final private String question;
    final private List<String> answers;
    final private int correct_answer;
}
