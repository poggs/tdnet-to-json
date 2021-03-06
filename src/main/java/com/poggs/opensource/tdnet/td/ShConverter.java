package com.poggs.opensource.tdnet.td;

import org.apache.camel.Message;
import org.json.simple.JSONObject;

/**
 * Convert a TD 'SH' message in XML format in to JSON
 *
 * @author pwh
 */
class ShConverter {

    private ShConverter() {
        throw new IllegalStateException("Utility class: cannot be instantiated");
    }

    @SuppressWarnings("unchecked")
    public static String convertMessage(Message message) {

        String msgString = message.getBody(String.class);

        JSONObject innerObj = new JSONObject();

        String areaId = msgString.substring(8, 10);
        innerObj.put("area_id", areaId);

        String toBerth = msgString.substring(12, 14);
        innerObj.put("address", toBerth);

        String descr = msgString.substring(14, 22);
        innerObj.put("data", descr);

        String timestamp = String.valueOf(message.getHeader("JMSTimestamp"));
        innerObj.put("time", timestamp);

        JSONObject outerObj = new JSONObject();
        outerObj.put("SH_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
