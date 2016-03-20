package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
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

        Message msgIn = new DefaultMessage();
        msgIn.setBody("<CB_MSG>X2CBL1272V54170825</CB_MSG>");
        msgIn.setHeader("JMSTimestamp", "1451649600000");

        String expectedMsgOutString = "{\"CB_MSG\":{\"area_id\":\"X2\",\"from\":\"L127\",\"time\":\"1451649600000\",\"descr\":\"2V54\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = CbConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}