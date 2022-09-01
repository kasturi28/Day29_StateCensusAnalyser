package com.blz.sample3;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

	
	String filePath = "IndianStateCensusData.csv";
    @Test
    public void givenStateCensusRecordShouldReturnNumberOfRecords() {
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile(filePath);
            Assert.assertEquals(29, countRecords);
        } catch (StateCensusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenIncorrectFileFormatShouldReturnCustomException() {
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = StateCensusAnalyser.readCensusFile("IndianStateCensusData.csv");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format", countRecords);
        } catch (StateCensusException e) {
        }
    }

    @Test
    public void givenIncorrectFileTypeShouldReturnCustomException() {
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("IndianStateCensusData.csv");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format", countRecords);
        } catch (StateCensusException e) {
        }
    }

    @Test
    public void givenCorrectFileTypeButIncorrectDelimterShouldReturnCustomException() {
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("IndianStateCensusData.csv");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format", countRecords);
        } catch (StateCensusException e) {
        }
    }

    @Test
    public void givenCorrectFileTypeButIncorrectHeaderShouldReturnCustomException() {
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            String[] header = {"State", "Population", "AreaInSqKm", "DensityPerSqKm"};
            boolean checkHeader = obj.readHeader("IndianStateCensusData.csv", header);
            Assert.assertTrue(checkHeader);

        } catch (StateCensusException e) {
        }
    }
}
