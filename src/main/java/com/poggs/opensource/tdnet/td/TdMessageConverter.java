package com.poggs.opensource.tdnet.td;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Converts a TD message in to a lightweight JSON format
 *
 * @author pwh
 */
@SuppressWarnings("unused")
public class TdMessageConverter implements Processor {

    public void process(Exchange exchange) throws Exception {

        String msg = exchange.getIn().getBody(String.class);

        String msgType = msg.substring(1, 3);

        String outMessage = null;

        if(msgType.equals("CA")) {
            outMessage = CaConverter.convertMessage(msg);
        } else if(msgType.equals("CB")) {
            outMessage = CbConverter.convertMessage(msg);
        } else if(msgType.equals("CC")) {
            outMessage = CcConverter.convertMessage(msg);
        } else if(msgType.equals("CT")) {
            outMessage = CtConverter.convertMessage(msg);
        } else if(msgType.equals("SF")) {
            outMessage = SfConverter.convertMessage(msg);
        } else if(msgType.equals("SG")) {
            outMessage = SgConverter.convertMessage(msg);
        } else if(msgType.equals("SH")) {
            outMessage = ShConverter.convertMessage(msg);
        } else {
            System.out.println("No converter found for " + msg);
        }

        exchange.getIn().setBody(outMessage);

    }

}
