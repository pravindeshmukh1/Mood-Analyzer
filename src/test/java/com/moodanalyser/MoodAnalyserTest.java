package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void whenGivenSad_shouldReturnSad(){
        MoodAnalyser moodanalyser=new MoodAnalyser("I Sad Mood");
        String message=moodanalyser.analyse();
        Assert.assertEquals("SAD",message);
    }
    @Test
    public void whenGivenHappy_shouldReturnHappy(){
        MoodAnalyser moodanalyser=new MoodAnalyser("“I am in Any Mood”");
        String message=moodanalyser.analyse();
        Assert.assertEquals("HAPPY",message);
    }

}
