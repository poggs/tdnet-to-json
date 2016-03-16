package com.poggs.opensource.tdnet.td;

import org.json.simple.JSONObject;

/**
 * Convert a TD 'SF' message in XML format in to JSON
 *
 * @author pwh
 */
class SfConverter {

    @SuppressWarnings("unchecked")
    public static String convertMessage(String message) {

        JSONObject innerObj = new JSONObject();

        String areaId = message.substring(8, 10);
        innerObj.put("area_id", areaId);

        String toBerth = message.substring(12, 14);
        innerObj.put("address", toBerth);

        String descr = message.substring(14, 16);
        innerObj.put("data", descr);

        JSONObject outerObj = new JSONObject();
        outerObj.put("SF_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
