package com.example.lw4;

import jakarta.validation.constraints.*;

import java.util.List;

public class SpecialAgent {
    @NotNull
    private String name;

    private String surname;

    @Size(min = 1, max = 3)
    @Pattern(regexp = "[0-9]{1,3}")
    private String code;

    @NotBlank
    private String status;

    @NotEmpty
    private String motto;

    @Size(min = 0, max = 4)
    private List<String> cars;

    @Min(value = 18)
    private int age;

    @Max(5)
    private int numberOfCurrentMissions;

    @Email
    private String email;
}