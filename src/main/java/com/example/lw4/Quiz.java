package com.example.lw4;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Quiz {
    public Quiz(String title, String question, List<String> answers, List<Integer> correct_answer) {
        this.id = counter;
        this.title = title;
        this.question = question;
        this.answers = answers;
        this.correct_answer = correct_answer;

        counter++;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getQuestion() { return question; }
    public List<String> getAnswers() { return answers; }
    public List<Integer> getCorrectAnswer() { return correct_answer; }

    private static int counter = 0;
    final private int id;
    @NotEmpty
    final private String title;

    @NotEmpty
    final private String question;

    @Size(min = 2)
    final private List<String> answers;

    final private List<Integer> correct_answer;
}
