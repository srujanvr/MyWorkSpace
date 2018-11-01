package com.exam;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class SensorTempAverageTest {

    SensorTempAverage sensorTempAverage=new SensorTempAverage();
    TreeMap<Integer,Double> timeTempMap=new TreeMap<Integer, Double>();
    TreeMap<Integer,Double> timeTempMap1=new TreeMap<Integer, Double>();
    String timeTempStr=null;

    @Before
    public void setUp() throws Exception {
        sensorTempAverage.setDuration(1000);
        timeTempStr="1,10000,40";
        timeTempMap.put(10000,40.0);
        timeTempMap.put(10002,45.0);
        timeTempMap.put(11015,50.0);
        timeTempMap.put(10005,42.0);

    }

    /**
     * Testing For String to Time Temperature Collection
     */
    @Test
    public void storeTimeTemp() {
        int key=sensorTempAverage.storeTimeTemp(timeTempStr,timeTempMap1).firstKey();
        assertEquals(10000,key);

    }

    /**
     * Testing For Average Calculation and final Data Format
     */

    @Test
    public void calculateAverage() {
        assertEquals("10000-10999:42.333333333333336",sensorTempAverage.calculateAverage(timeTempMap).get(0));
    }

    /**
     * Testing Duration Getter
     */
    @Test
    public void getDuration() {
        assertTrue(sensorTempAverage.getDuration()==1000);
    }

    /**
     * Testing Setter Duration
     */

    @Test
    public void setDuration() {
        sensorTempAverage.setDuration(5000);
        assertTrue(sensorTempAverage.getDuration()==5000);
    }
}