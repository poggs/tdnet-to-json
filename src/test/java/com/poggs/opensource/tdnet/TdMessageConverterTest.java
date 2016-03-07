package com.poggs.opensource.tdnet;

import com.poggs.opensource.tdnet.td.TdMessageConverter;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.util.List;

/**
 * Tests for the TdMessageConverter class
 */
public class TdMessageConverterTest extends CamelTestSupport {

    @SuppressWarnings("unused")
    @EndpointInject(uri="mock:result")
    private MockEndpoint resultEndpoint;

    @SuppressWarnings("unused")
    @EndpointInject(uri="direct:start")
    private ProducerTemplate template;

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                Processor tdMessageProcessor = new TdMessageConverter();
                from("direct:start").process(tdMessageProcessor).to("mock:result");
            }
        };
    }

    @Override
    public boolean isDumpRouteCoverage() {
        return true;
    }

    @Test
    public void sendTdCaMessage() throws Exception {

        final String expectedMessageString = "{\"CA_MSG\":{\"area_id\":\"BL\",\"from\":\"0109\",\"to\":\"0111\",\"descr\":\"1M61\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<CA_MSG>BLCA010901111M61170754</CA_MSG>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void sendTdCbMessage() throws Exception {

        final String expectedMessageString = "{\"CB_MSG\":{\"area_id\":\"X2\",\"from\":\"L127\",\"descr\":\"2V54\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<CB_MSG>X2CBL1272V54170825</CB_MSG>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void sendTdCcMessage() throws Exception {

        String expectedMessageString = "{\"CC_MSG\":{\"area_id\":\"R1\",\"to\":\"3266\",\"descr\":\"1A49\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<CC_MSG>R1CC32661A49170851</CC_MSG>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void sendTdSfMessage() throws Exception {

        String expectedMessageString = "{\"SF_MSG\":{\"area_id\":\"NK\",\"address\":\"08\",\"data\":\"10\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<SF_MSG>NKSF0810170914</SF_MSG>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void sendTdSgMessage() throws Exception {

        String expectedMessageString = "{\"SG_MSG\":{\"area_id\":\"EC\",\"address\":\"34\",\"data\":\"01F0F8FF\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<SG_MSG>ECSG3401F0F8FF144308</SG_MSG>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void sendTdShMessage() throws Exception {

        String expectedMessageString = "{\"SH_MSG\":{\"area_id\":\"MZ\",\"address\":\"58\",\"data\":\"39000000\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<SH_MSG>MZSH5839000000042707</SH_MSG>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

}