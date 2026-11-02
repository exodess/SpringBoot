package com.example.lw2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class QuizController {
    final private List<Quiz> quiz_list = List.of(
            new Quiz("The Linux command", "Which command is used to list files and directories in a Linux terminal?",
                    List.<String>of("cat", "mkdir", "ls", "rm"), 3),

            new Quiz("The PC memory", "Which of the following is considered volatile memory in a computer system?",
                    List.<String>of("HDD", "RAM", "SSD", "ROM"), 2),

            new Quiz("The С++ file extension", "What is the correct file extension for a standard C++ source code file?",
                    List.<String>of(".cs", ".cpp", ".py", ".html"), 2),

            new Quiz("The HTTP acronym", "What does the acronym HTTP stand for in networking?",
                    List.<String>of(
                            "HyperText Transmission Process",
                            "Hyperlink Transfer Technology",
                            "HyperText Test Program",
                            "HyperText Transfer Protocol"), 4),

            new Quiz("The Git command", "Which Git command is used to record changes to the local repository?",
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
    List<Quiz> getQuizList() {
        return quiz_list;
    }
}