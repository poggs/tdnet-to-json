package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.json.simple.JSONObject;

/**
 * Convert a TD 'CC' message in XML format in to JSON
 *
 * @author pwh
 */
class CcConverter {

    @SuppressWarnings("unchecked")
    public static String convertMessage(Message message) {

        String msgString = message.getBody(String.class);

        JSONObject innerObj = new JSONObject();

        String areaId = msgString.substring(8, 10);
        innerObj.put("area_id", areaId);

        String toBerth = msgString.substring(12, 16);
        innerObj.put("to", toBerth);

        String descr = msgString.substring(16, 20);
        innerObj.put("descr", descr);

        String timestamp = (String) message.getHeader("JMSTimestamp");
        innerObj.put("time", timestamp);

        JSONObject outerObj = new JSONObject();
        outerObj.put("CC_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
