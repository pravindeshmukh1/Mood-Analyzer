package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser defaultMoodAnalyser() {
        try {
            Constructor constructor = Class.forName("com.moodanalyser.MoodAnalyser").getConstructor();
            MoodAnalyser moodAnalyser = (MoodAnalyser) constructor.newInstance();
            return moodAnalyser;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String classname, Class constructor) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyser = Class.forName(classname);
            return moodAnalyser.getConstructor(constructor);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new MoodAnalyserException("Class not Found", MoodAnalyserException.UserDefineDataType.NO_SUCH_CLASS);
        }
    }
}
