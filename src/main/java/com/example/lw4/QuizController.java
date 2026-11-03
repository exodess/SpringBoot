package com.example.lw4;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController {
    private ArrayList<Quiz> quiz_list = new ArrayList<>();

    QuizController() {
        quiz_list.add(new Quiz("The Linux command", "Which command is used to list files and directories in a Linux terminal?",
                List.<String>of("cat", "mkdir", "ls", "rm"), List.of(3)));

        quiz_list.add(new Quiz("The PC memory", "Which of the following is considered volatile memory in a computer system?",
                List.<String>of("HDD", "RAM", "SSD", "ROM"), List.of(2)));

        quiz_list.add(new Quiz("The С++ file extension", "What is the correct file extension for a standard C++ source code file?",
                List.<String>of(".cs", ".cpp", ".py", ".html"), List.of(2)));

        quiz_list.add(new Quiz("The HTTP acronym", "What does the acronym HTTP stand for in networking?",
                List.<String>of(
                        "HyperText Transmission Process",
                        "Hyperlink Transfer Technology",
                        "HyperText Test Program",
                        "HyperText Transfer Protocol"), List.of(2)));

        quiz_list.add(new Quiz("The Git command", "Which Git command is used to record changes to the local repository?",
                List.<String>of(
                        "git commit",
                        "git push",
                        "git pull",
                        "git clone"), List.of(1)));
    }

    @PostMapping("/api/quiz")
    ApiResponse sendAnswer(@RequestParam int question, @RequestParam int answer) {
        var quiz = quiz_list.get(question);

        if(quiz.getCorrectAnswer().contains(answer)) {
            return new ApiResponse(true, "Congratulations, you're right!");
        }

        else {
            return new ApiResponse(false, "Wrong answer! Please, try again.");
        }
    }

    @GetMapping("/api/quiz")
    List<Quiz> getQuizList() {
        return quiz_list;
    }

    @PostMapping("/api/quizzes")
    public QuizData createQuiz(@Valid @RequestBody Quiz quiz) {
        quiz_list.add(quiz);

        return new QuizData(quiz);
    }

    @GetMapping("/api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) {
        return quiz_list.get(id);
    }

    @GetMapping("/api/quizzes")
    public List<QuizData> getAllQuizzes() {
        List<QuizData> result = new java.util.ArrayList<>(List.of());

        for(int i = 0; i < quiz_list.size(); ++i) {
            Quiz temp = quiz_list.get(i);
            result.add(new QuizData(temp));
        }

        return result;
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public ApiResponse solveQuiz(@PathVariable int id, @RequestParam("answer") int answer) {
        if(id >= quiz_list.size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        var quiz = quiz_list.get(id);

        if(quiz.getCorrectAnswer().contains(answer)) {
            return new ApiResponse(true, "Congratulations, you're right!");
        }

        else {
            return new ApiResponse(false, "Wrong answer! Please, try again.");
        }
    }
}
