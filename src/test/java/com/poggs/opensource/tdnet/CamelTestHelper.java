package com.poggs.opensource.tdnet;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Helper methods for Camel tests
 *
 * @author pwh
 */
class CamelTestHelper {

    /**
     * Helper method to send a message through Camel and check the response
     *
     * @param template              A ProducerTemplate
     * @param resultEndpoint        A MockEndpoint
     * @param msgIn                 The input message as a String
     * @param expectedMessageString The expected output message as a String
     * @throws Exception if the message could not be processed
     */
    public static void sendMessage(ProducerTemplate template, MockEndpoint resultEndpoint, String msgIn, String expectedMessageString, String timestamp) throws Exception {

        template.send("direct:start", exchange -> {
            Message in = exchange.getIn();
            in.setBody(msgIn);
            in.setHeader("JMSTimestamp", timestamp);
        });

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

}
