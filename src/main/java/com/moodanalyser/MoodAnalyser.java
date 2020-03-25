package com.moodanalyser;


import java.util.Objects;

public class MoodAnalyser {
    private final String message;


    public MoodAnalyser(String message) {
        this.message = message;
    }

    public MoodAnalyser() {
        message="Default Constructor";
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Mood Analyser");
    }

    public String analyse() throws MoodAnalyserException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyserException("Plz enter the mood can not empty", MoodAnalyserException.UserDefineDataType.EMPTY_EXCEPTION);
            if (message.contains("Sad"))
                return "SAD";
            return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException("Plz enter the mood can not null", MoodAnalyserException.UserDefineDataType.NULL_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MoodAnalyser that = (MoodAnalyser) obj;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

}

