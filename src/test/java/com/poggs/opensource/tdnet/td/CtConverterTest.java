package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the TD 'CT' message converter
 *
 * @author pwh
 */
public class CtConverterTest {

    @Test
    public void convertsMessage() throws ParseException {

        Message msgIn = new DefaultMessage();
        msgIn.setBody("<CT_MSG>LSCT0332033147</CT_MSG>");
        msgIn.setHeader("JMSTimestamp", "1451649600000");

        String expectedMsgOutString = "{\"CT_MSG\":{\"area_id\":\"LS\",\"report_time\":\"0332\",\"time\":\"1451649600000\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = CtConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}