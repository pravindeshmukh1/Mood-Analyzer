package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void whenGivenSad_shouldReturnSad() throws MoodAnalyserException {
        MoodAnalyser moodanalyser=new MoodAnalyser("I Sad Mood");
        String message=moodanalyser.analyse();
        Assert.assertEquals("SAD",message);
    }
    @Test
    public void whenGivenHappy_shouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodanalyser=new MoodAnalyser("I am in Any Mood");
        String message=moodanalyser.analyse();
        Assert.assertEquals("HAPPY",message);
    }
    @Test
    public void whenGivenNull_shouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodanalyser=new MoodAnalyser("Null");
        String message=moodanalyser.analyse();
        Assert.assertEquals("HAPPY",message);
    }

    @Test
    public void whenGivenNull_shouldReturnCustomException() throws MoodAnalyserException{
        try{
            MoodAnalyser moodAnalyser=new MoodAnalyser(null);
            moodAnalyser.analyse();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }

    @Test
    public void whenGivenEmpty_shouldReturnCustomException(){
        try {
            MoodAnalyser moodAnalyser=new MoodAnalyser("");
            moodAnalyser.analyse();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.UserDefineDataType.EMPTY_EXCEPTION,e.userDefinedObject);
        }
    }
}
