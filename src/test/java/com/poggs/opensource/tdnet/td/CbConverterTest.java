package com.poggs.opensource.tdnet.td;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the TD 'CB' message converter
 *
 * @author pwh
 */
public class CbConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        String msgIn = "<CB_MSG>X2CBL1272V54170825</CB_MSG>";

        String expectedMsgOutString = "{\"CB_MSG\":{\"area_id\":\"X2\",\"from\":\"L127\",\"descr\":\"2V54\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = CbConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}