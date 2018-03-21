package com.poggs.opensource.tdnet.td;

import org.apache.camel.CamelContext;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultMessage;
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

        CamelContext camelContext = new DefaultCamelContext();
        Message msgIn = new DefaultMessage(camelContext);
        msgIn.setHeader("JMSTimestamp", 1451649600000L);
        msgIn.setBody("<SF_MSG>NKSF0810170914</SF_MSG>");

        String expectedMsgOutString = "{\"SF_MSG\":{\"area_id\":\"NK\",\"address\":\"08\",\"data\":\"10\",\"time\":\"1451649600000\"}}";
        JSONParser parser = new JSONParser();
        JSONObject expectedMsgOut = (JSONObject) parser.parse(expectedMsgOutString);

        String msgOut = SfConverter.convertMessage(msgIn);
        JSONObject actualMsgOut = (JSONObject) parser.parse(msgOut);

        assertEquals(expectedMsgOut, actualMsgOut);

    }

}