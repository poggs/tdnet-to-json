package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the TD 'SH' message converter
 *
 * @author pwh
 */
public class ShConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        Message msgIn = new DefaultMessage();
        msgIn.setHeader("JMSTimestamp", 1451649600000L);
        msgIn.setBody("<SH_MSG>ECSG3401F0F8FF144308</SG_MSG>");

        String expectedMsgOutString = "{\"SH_MSG\":{\"area_id\":\"EC\",\"address\":\"34\",\"data\":\"01F0F8FF\",\"time\":\"1451649600000\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = ShConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}