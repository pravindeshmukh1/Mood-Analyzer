package com.moodanalyser;

public class MoodAnalyser {
    private final String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Mood Analyser");
    }

    public String analyse() throws MoodAnalyserException {
        try {
            if (message.contains("Sad"))
                return "SAD";
            return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException("Plz enter the mood can not null", MoodAnalyserException.UserDefineDataType.NULL_EXCEPTION);
        }
    }
}
