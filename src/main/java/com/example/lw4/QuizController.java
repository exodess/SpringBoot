package com.example.lw4;

import com.example.lw3.ApiResponse;
import com.example.lw3.Quiz;
import com.example.lw3.QuizData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    private List<com.example.lw3.Quiz> quiz_list = List.of(
            new com.example.lw3.Quiz("The Linux command", "Which command is used to list files and directories in a Linux terminal?",
                    List.<String>of("cat", "mkdir", "ls", "rm"), 3),

            new com.example.lw3.Quiz("The PC memory", "Which of the following is considered volatile memory in a computer system?",
                    List.<String>of("HDD", "RAM", "SSD", "ROM"), 2),

            new com.example.lw3.Quiz("The С++ file extension", "What is the correct file extension for a standard C++ source code file?",
                    List.<String>of(".cs", ".cpp", ".py", ".html"), 2),

            new com.example.lw3.Quiz("The HTTP acronym", "What does the acronym HTTP stand for in networking?",
                    List.<String>of(
                            "HyperText Transmission Process",
                            "Hyperlink Transfer Technology",
                            "HyperText Test Program",
                            "HyperText Transfer Protocol"), 4),

            new com.example.lw3.Quiz("The Git command", "Which Git command is used to record changes to the local repository?",
                    List.<String>of(
                            "git commit",
                            "git push",
                            "git pull",
                            "git clone"), 1)
    );

    @PostMapping("/api/quiz")
    ApiResponse sendAnswer(@RequestParam int question, @RequestParam int answer) {
        var quiz = quiz_list.get(question);

        if(answer == quiz.getCorrectAnswer()) {
            return new ApiResponse(true, "Congratulations, you're right!");
        }

        else {
            return new ApiResponse(false, "Wrong answer! Please, try again.");
        }
    }

    @GetMapping("/api/quiz")
    List<com.example.lw3.Quiz> getQuizList() {
        return quiz_list;
    }

    @PostMapping("/api/quizzes")
    public QuizData createQuiz(@RequestBody com.example.lw3.Quiz quiz) {
        quiz_list.add(quiz);

        return new QuizData(quiz_list.size() - 1, quiz.getTitle(), quiz.getQuestion(), quiz.getAnswers());
    }

    @GetMapping("/api/quizzes/{id}")
    public com.example.lw3.Quiz getQuiz(@PathVariable int id) {
        return quiz_list.get(id);
    }

    @GetMapping("/api/quizzes")
    public List<QuizData> getAllQuizzes() {
        List<QuizData> result = new java.util.ArrayList<>(List.of());

        for(int i = 0; i < quiz_list.size(); ++i) {
            Quiz temp = quiz_list.get(i);
            result.add(new QuizData(i, temp.getTitle(), temp.getQuestion(), temp.getAnswers()));
        }

        return result;
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public ApiResponse solveQuiz(@PathVariable int id, @RequestParam("answer") int answer) {
        var quiz = quiz_list.get(id);

        if(quiz.getCorrectAnswer() == answer) {
            return new ApiResponse(true, "Congratulations, you're right!");
        }

        else {
            return new ApiResponse(false, "Wrong answer! Please, try again.");
        }
    }
}
