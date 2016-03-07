package com.poggs.opensource.tdnet.td;

import org.json.simple.JSONObject;

/**
 * Convert a TD 'CA' message in XML format in to JSON
 *
 * @author pwh
 */
class CtConverter {

    public static String convertMessage(String message) {

        JSONObject innerObj = new JSONObject();

        String areaId = message.substring(8, 10);
        innerObj.put("area_id", areaId);

        String fromBerth = message.substring(12, 16);
        innerObj.put("report_time", fromBerth);

        JSONObject outerObj = new JSONObject();
        outerObj.put("CT_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
