package com.poggs.opensource.tdnet;

import com.poggs.opensource.tdnet.td.TdMessageConverter;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

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

        final String msgIn = "<CA_MSG>BLCA010901111M61170754</CA_MSG>";
        final String expectedMessageString = "{\"CA_MSG\":{\"area_id\":\"BL\",\"from\":\"0109\",\"to\":\"0111\",\"descr\":\"1M61\"}}";

        CamelTestHelper.sendMessage(template, resultEndpoint, msgIn, expectedMessageString);

    }

    @Test
    public void sendTdCbMessage() throws Exception {

        final String msgIn = "<CB_MSG>X2CBL1272V54170825</CB_MSG>";
        final String expectedMessageString = "{\"CB_MSG\":{\"area_id\":\"X2\",\"from\":\"L127\",\"descr\":\"2V54\"}}";

        CamelTestHelper.sendMessage(template, resultEndpoint, msgIn, expectedMessageString);

    }

    @Test
    public void sendTdCcMessage() throws Exception {

        final String msgIn = "<CC_MSG>R1CC32661A49170851</CC_MSG>";
        final String expectedMessageString = "{\"CC_MSG\":{\"area_id\":\"R1\",\"to\":\"3266\",\"descr\":\"1A49\"}}";

        CamelTestHelper.sendMessage(template, resultEndpoint, msgIn, expectedMessageString);

    }

    @Test
    public void sendTdSfMessage() throws Exception {

        final String msgIn = "<SF_MSG>NKSF0810170914</SF_MSG>";
        final String expectedMessageString = "{\"SF_MSG\":{\"area_id\":\"NK\",\"address\":\"08\",\"data\":\"10\"}}";

        CamelTestHelper.sendMessage(template, resultEndpoint, msgIn, expectedMessageString);

    }

    @Test
    public void sendTdSgMessage() throws Exception {

        final String msgIn = "<SG_MSG>ECSG3401F0F8FF144308</SG_MSG>";
        final String expectedMessageString = "{\"SG_MSG\":{\"area_id\":\"EC\",\"address\":\"34\",\"data\":\"01F0F8FF\"}}";

        CamelTestHelper.sendMessage(template, resultEndpoint, msgIn, expectedMessageString);

    }

    @Test
    public void sendTdShMessage() throws Exception {

        final String msgIn = "<SH_MSG>MZSH5839000000042707</SH_MSG>";
        final String expectedMessageString = "{\"SH_MSG\":{\"area_id\":\"MZ\",\"address\":\"58\",\"data\":\"39000000\"}}";

        CamelTestHelper.sendMessage(template, resultEndpoint, msgIn, expectedMessageString);

    }

}