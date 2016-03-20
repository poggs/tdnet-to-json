package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the TD 'CA' message converter
 *
 * @author pwh
 */
public class CaConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        Message msgIn = new DefaultMessage();
        msgIn.setHeader("JMSTimestamp", "1451649600000");
        msgIn.setBody("<CA_MSG>BLCA010901111M61170754</CA_MSG>");

        String expectedMsgOutString = "{\"CA_MSG\":{\"area_id\":\"BL\",\"from\":\"0109\",\"to\":\"0111\",\"time\":\"1451649600000\",\"descr\":\"1M61\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = CaConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}