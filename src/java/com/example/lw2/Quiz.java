package com.example.lw2;

import com.example.lw1.Question;

import java.util.List;

public class Quiz extends Question {
    public Quiz(String title, String question, List<String> answers, int correct_answer) {
        super(question, answers, correct_answer);
        this._title = title;
    }

    public String getTitle() { return _title; }

    final protected String _title;
}
