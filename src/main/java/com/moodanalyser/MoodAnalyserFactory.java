package com.moodanalyser;

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.lang.annotation.Target;
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
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException("Class not Found", MoodAnalyserException.UserDefineDataType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException("Method not Food", MoodAnalyserException.UserDefineDataType.NO_SUCH_METHOD);
        }
    }

    public static MoodAnalyser parameterizedMoodAnalyser(String message) {
        try {
            Constructor<?> constructor = Class.forName("com.moodanalyser.MoodAnalyser").getConstructor(String.class);
            return (MoodAnalyser) constructor.newInstance(message);
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

    public static String invokedMethod(MoodAnalyser moodAnalyser, String methodName) throws MoodAnalyserException {
        try {
            return (String) moodAnalyser.getClass().getMethod(methodName).invoke(moodAnalyser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException("Method Not Found",MoodAnalyserException.UserDefineDataType.NO_SUCH_METHOD);
        }
        return null;
    }
}

