package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Test
    public void whenGivenSad_shouldReturnSad() throws MoodAnalyserException {
        MoodAnalyser moodanalyser = new MoodAnalyser("I Sad Mood");
        String message = moodanalyser.analyse();
        Assert.assertEquals("SAD", message);
    }

    @Test
    public void whenGivenHappy_shouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodanalyser = new MoodAnalyser("I am in Any Mood");
        String message = moodanalyser.analyse();
        Assert.assertEquals("HAPPY", message);
    }

    @Test
    public void whenGivenNull_shouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodanalyser = new MoodAnalyser("Null");
        String message = moodanalyser.analyse();
        Assert.assertEquals("HAPPY", message);
    }

    @Test
    public void whenGivenNull_shouldReturnCustomException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyse();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.NULL_EXCEPTION, e.userDefinedObject);
        }
    }

    @Test
    public void whenGivenEmpty_shouldReturnCustomException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyse();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.EMPTY_EXCEPTION, e.userDefinedObject);
        }
    }

    //4
    @Test
    public void givenMoodAnalyserClass_usingDefaultConstructor_whenProper_shouldReturnObject() {
        MoodAnalyser moodAnalyzerFactory = MoodAnalyserFactory.defaultMoodAnalyser();
        Assert.assertEquals(new MoodAnalyser(), moodAnalyzerFactory);
    }

    @Test
    public void givenClassName_whenWrong_shouldReturnCustomException() {
        try {
            MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyser1", String.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.NO_SUCH_CLASS, e.userDefinedObject);
        }
    }

    @Test
    public void givenClassName_whenConstructorNotProper_shouldReturnCustomException() {
        try {
            MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyser", Integer.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.NO_SUCH_METHOD, e.userDefinedObject);
        }
    }

    @Test
    public void givenMoodAnalyser_withParameterConstructor_shouldReturnObject() {
        MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.parameterizedMoodAnalyser("Happy Mood");
        Assert.assertEquals(new MoodAnalyser("Happy Mood"), moodAnalyserFactory);
    }

    @Test
    public void givenHappyMessage_usingMethodInvoked_whenProper_shouldReturnHappyMood() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.parameterizedMoodAnalyser("Happy Mood");
        try {
            String mood = MoodAnalyserFactory.invokedMethod(moodAnalyser, "analyseMethod");
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_usingMethodInvoked_whenImProper_shouldReturnHappyMood() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.parameterizedMoodAnalyser("Happy Mood");
        try {
            String mood = MoodAnalyserFactory.invokedMethod(moodAnalyser, "AnalyseMethod");
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
}
