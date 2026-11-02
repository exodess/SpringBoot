package com.example.lw1;

import java.util.Scanner;

public class UserInput {
    public UserInput() { sc = new Scanner(System.in); }

    public int getInt() {
        System.out.print("> ");
        return sc.nextInt();
    }

    public String getString() {
        System.out.print("> ");
        return sc.next();
    }

    final private Scanner sc;
}
