package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.json.simple.JSONObject;

/**
 * Convert a TD 'CB' message in XML format in to JSON
 *
 * @author pwh
 */
class CbConverter {

    @SuppressWarnings("unchecked")
    public static String convertMessage(Message message) {

        String msgString = message.getBody(String.class);

        JSONObject innerObj = new JSONObject();

        String areaId = msgString.substring(8, 10);
        innerObj.put("area_id", areaId);

        String fromBerth = msgString.substring(12, 16);
        innerObj.put("from", fromBerth);

        String descr = msgString.substring(16, 20);
        innerObj.put("descr", descr);

        String timestamp = (String) message.getHeader("JMSTimestamp");
        innerObj.put("time", timestamp);

        JSONObject outerObj = new JSONObject();
        outerObj.put("CB_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
