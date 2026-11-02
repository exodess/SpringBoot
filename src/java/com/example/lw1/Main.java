package com.example.lw1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Для ввода данних из консоли
        UserInput input = new UserInput();

        out("Hello! Ny name is Igor.");
        out("I was created in 2026.");

        out("Please, remind me your name.");
        String username = input.getString();
        out("What a great name you have, " + username + "!");

        out("Let me quess your age.");
        out("Enter remainders of dividing your age by 3, 5 and 7.");

        var arr = new ArrayList<Integer>(3);
        arr.add(input.getInt());
        arr.add(input.getInt());
        arr.add(input.getInt());
        int age = (arr.get(0) * 70 + arr.get(1) * 21 + arr.get(2) * 15) % 105;

        out("Your age is " + age + ": good time to start Java programming!");

        // Создаем объекты типа Question
        List<Question> array_question = List.<Question>of(
                new Question("Which command is used to list files and directories in a Linux terminal?",
                        List.<String>of("cat", "mkdir", "ls", "rm"), 3),

                new Question("Which of the following is considered volatile memory in a computer system?",
                        List.<String>of("HDD", "RAM", "SSD", "ROM"), 2),

                new Question("What is the correct file extension for a standard C++ source code file?",
                        List.<String>of(".cs", ".cpp", ".py", ".html"), 2),

                new Question("What does the acronym HTTP stand for in networking?",
                        List.<String>of(
                                "HyperText Transmission Process",
                                "Hyperlink Transfer Technology",
                                "HyperText Test Program",
                                "HyperText Transfer Protocol"), 4),

                new Question("Which Git command is used to record changes to the local repository?",
                        List.<String>of(
                                "git commit",
                                "git push",
                                "git pull",
                                "git clone"), 1)

        );

        questionsHandling(array_question, input);

        out("Congratulations, have a nice day!");
    }

    private static void questionsHandling(List<Question> list, UserInput input) {
        for(var question : list) {
            out(question.getQuestion());

            int i = 1;
            for(var answer : question.getAnswers())
                out(i++ + ". " + answer);

            while(true) {
                int user_answer = input.getInt();

                if (user_answer == question.getCorrectAnswer()) break;
                else {
                    out("Please, try again.");
                }
            }
        }
    }

    private static void out(String text) {
        System.out.println(text);
    }
}
