package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the TD 'CC' message converter
 *
 * @author pwh
 */
public class CcConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        Message msgIn = new DefaultMessage();
        msgIn.setHeader("JMSTimestamp", 1451649600000L);
        msgIn.setBody("<CC_MSG>R1CC32661A49170851</CC_MSG>");

        String expectedMsgOutString = "{\"CC_MSG\":{\"area_id\":\"R1\",\"to\":\"3266\",\"time\":\"1451649600000\",\"descr\":\"1A49\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = CcConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}