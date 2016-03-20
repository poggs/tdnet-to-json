package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.json.simple.JSONObject;

/**
 * Convert a TD 'SF' message in XML format in to JSON
 *
 * @author pwh
 */
class SfConverter {

    @SuppressWarnings("unchecked")
    public static String convertMessage(Message message) {

        String msgString = message.getBody(String.class);

        JSONObject innerObj = new JSONObject();

        String areaId = msgString.substring(8, 10);
        innerObj.put("area_id", areaId);

        String toBerth = msgString.substring(12, 14);
        innerObj.put("address", toBerth);

        String descr = msgString.substring(14, 16);
        innerObj.put("data", descr);

        String timestamp = (String) message.getHeader("JMSTimestamp");
        innerObj.put("time", timestamp);

        JSONObject outerObj = new JSONObject();
        outerObj.put("SF_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
