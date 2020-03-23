package com.moodanalyser;

public class MoodAnalyser {
    private final String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Mood Analyser");
    }

    public String analyse() {
        if (message.contains("Sad"))
            return "SAD";
        return "HAPPY";
    }
}
