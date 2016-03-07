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
public class SfConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        String msgIn = "<SF_MSG>NKSF0810170914</SF_MSG>";

        String expectedMsgOutString = "{\"SF_MSG\":{\"area_id\":\"NK\",\"address\":\"08\",\"data\":\"10\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = SfConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}