package com.poggs.opensource.tdnet.td;

import org.json.simple.JSONObject;

/**
 * Convert a TD 'SH' message in XML format in to JSON
 *
 * @author pwh
 */
class ShConverter {

    @SuppressWarnings("unchecked")
    public static String convertMessage(String message) {

        JSONObject innerObj = new JSONObject();

        String areaId = message.substring(8, 10);
        innerObj.put("area_id", areaId);

        String toBerth = message.substring(12, 14);
        innerObj.put("address", toBerth);

        String descr = message.substring(14, 22);
        innerObj.put("data", descr);

        JSONObject outerObj = new JSONObject();
        outerObj.put("SH_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
