package com.poggs.opensource.tdnet.td;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts a TD message in to a lightweight JSON format
 *
 * @author pwh
 */
@SuppressWarnings("unused")
public class TdMessageConverter implements Processor {

    Logger logger = LoggerFactory.getLogger(TdMessageConverter.class);

    public void process(Exchange exchange) throws Exception {

        Message msg = exchange.getIn();

        String msgType = msg.getBody(String.class).substring(1, 3);

        String outMessage = null;

        switch (msgType) {
            case "CA":
                outMessage = CaConverter.convertMessage(msg);
                break;
            case "CB":
                outMessage = CbConverter.convertMessage(msg);
                break;
            case "CC":
                outMessage = CcConverter.convertMessage(msg);
                break;
            case "CT":
                outMessage = CtConverter.convertMessage(msg);
                break;
            case "SF":
                outMessage = SfConverter.convertMessage(msg);
                break;
            case "SG":
                outMessage = SgConverter.convertMessage(msg);
                break;
            case "SH":
                outMessage = ShConverter.convertMessage(msg);
                break;
            default:
                logger.error("No converter found for " + msg);
                break;
        }

        exchange.getIn().setBody(outMessage);

    }

}
