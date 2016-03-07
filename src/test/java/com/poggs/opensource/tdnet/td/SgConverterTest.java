package com.poggs.opensource.tdnet.td;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the TD 'SF' message converter
 *
 * @author pwh
 */
public class SgConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        String msgIn = "<SG_MSG>ECSG3401F0F8FF144308</SG_MSG>";

        String expectedMsgOutString = "{\"SG_MSG\":{\"area_id\":\"EC\",\"address\":\"34\",\"data\":\"01F0F8FF\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = SgConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}