package com.poggs.opensource.tdnet.td;

import org.json.simple.JSONObject;

/**
 * Convert a TD 'CA' message in XML format in to JSON
 *
 * @author pwh
 */
class CaConverter {

    @SuppressWarnings("unchecked")
    public static String convertMessage(String message) {

        JSONObject innerObj = new JSONObject();

        String areaId = message.substring(8, 10);
        innerObj.put("area_id", areaId);

        String fromBerth = message.substring(12, 16);
        innerObj.put("from", fromBerth);

        String toBerth = message.substring(16, 20);
        innerObj.put("to", toBerth);

        String descr = message.substring(20, 24);
        innerObj.put("descr", descr);

        JSONObject outerObj = new JSONObject();
        outerObj.put("CA_MSG", innerObj);

        return outerObj.toJSONString();

    }

}
