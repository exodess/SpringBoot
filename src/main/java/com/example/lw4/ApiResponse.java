package com.example.lw4;

public class ApiResponse {
    public ApiResponse(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }

    private final boolean success;
    private final String feedback;
}
