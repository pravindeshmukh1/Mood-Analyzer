package com.moodanalyser;



public class MoodAnalyserException extends Throwable {


    public UserDefineDataType userDefinedObject;

    public MoodAnalyserException(String message, UserDefineDataType userDefinedObject) {
        super(message);
        this.userDefinedObject = userDefinedObject;
    }

    public enum UserDefineDataType {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS
    };
}
