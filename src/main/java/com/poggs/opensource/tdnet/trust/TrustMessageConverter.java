package com.poggs.opensource.tdnet.trust;

import com.poggs.opensource.tdnet.MessageConverterHelper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.simple.JSONObject;
import uk.co.networkrail.xml.ns._2008.eai.Message;
import uk.co.networkrail.xml.ns._2008.train.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringReader;
import java.text.SimpleDateFormat;

/**
 * Converts a TRUST message in to a lightweight JSON format
 *
 * @author pwh
 */
public class TrustMessageConverter extends TrustMessageConverterConstants implements Processor {

    public void process(Exchange exchange) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        String msgIn = exchange.getIn().getBody(String.class);

        StringReader msgInReader = new StringReader(msgIn);

        Object msgOut = jaxbUnmarshaller.unmarshal(msgInReader);

        String response = null;

        if (msgOut.getClass() == TrainActivationMsgV1.class) {
            response = activationToJson((TrainActivationMsgV1) msgOut);
        } else if (msgOut.getClass() == TrainCancellationMsgV1.class) {
            response = cancellationToJson((TrainCancellationMsgV1) msgOut);
        } else if (msgOut.getClass() == TrainMovementMsgV1.class) {
            response = movementToJson((TrainMovementMsgV1) msgOut);
        } else if (msgOut.getClass() == TrainReinstatementMsgV1.class) {
            response = reinstatementToJson((TrainReinstatementMsgV1) msgOut);
        } else if (msgOut.getClass() == TrainChangeOriginMsgV1.class) {
            response = trainChangeOriginToJson((TrainChangeOriginMsgV1) msgOut);
        } else if (msgOut.getClass() == TrainChangeIdentityMsgV1.class) {
            response = trainChangeIdentityToJson((TrainChangeIdentityMsgV1) msgOut);
        } else if (msgOut.getClass() == TrainChangeLocationMsgV1.class) {
            response = trainChangeLocationToJson((TrainChangeLocationMsgV1) msgOut);
        }

        exchange.getIn().setBody(response);

    }

    /**
     * Convert a TrainActivationV1 message to JSON
     *
     * @return A JSON type 0001 message
     */
    @SuppressWarnings("unchecked")
    private String activationToJson(TrainActivationMsgV1 msg) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_ACTIVATION_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(SCHEDULE_SOURCE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getScheduleSource()));
        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainActivationData().getTrainFileAddress());
        responseBody.put(SCHEDULE_END_DATE_FIELD, dateFormat.format(msg.getTrainActivationData().getScheduleEndTimestamp().toGregorianCalendar().getTime()));
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainActivationData().getOriginalTrainID());
        responseBody.put(TP_ORIGIN_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainActivationData().getTrainPlanOriginTimestamp()));
        responseBody.put(CREATION_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseBody.put(TP_ORIGIN_STANOX_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getTrainPlanOrigin()));
        responseBody.put(ORIGIN_DEP_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainActivationData().getWTTTimestamp()));
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainActivationData().getTrainServiceCode());
        responseBody.put(TOC_ID_FIELD, msg.getTrainActivationData().getTOC());
        responseBody.put(D1266_RECORD_NUMBER_FIELD, msg.getTrainActivationData().getTOPSUID());
        responseBody.put(TRAIN_CALL_TYPE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getEventSource()));
        responseBody.put(TRAIN_UID_FIELD, msg.getTrainActivationData().getUIDNumber());
        responseBody.put(TRAIN_CALL_MODE_FIELD, msg.getTrainActivationData().getTrainCallMode());
        responseBody.put(SCHEDULE_TYPE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getScheduleType()));
        responseBody.put(SCHEDULE_ORIGIN_STANOX_FIELD, msg.getTrainActivationData().getLocationStanox()); // CHECK
        responseBody.put(SCHEDULE_WTT_ID_FIELD, msg.getTrainActivationData().getScheduledWTTID());
        responseBody.put(SCHEDULE_START_DATE_FIELD, dateFormat.format(msg.getTrainActivationData().getScheduleStartTimestamp().toGregorianCalendar().getTime()));

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainCancellationMsgV1 message to JSON
     *
     * @return A JSON type 0002 message
     */
    @SuppressWarnings("unchecked")
    private String cancellationToJson(TrainCancellationMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_CANCELLATION_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainCancellationData().getTrainFileAddress());
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainCancellationData().getTrainServiceCode());
        responseBody.put(ORIGIN_LOCATION_STANOX_FIELD, msg.getTrainCancellationData().getOriginStanox());
        responseBody.put(TOC_ID_FIELD, msg.getTrainCancellationData().getTOC());
        responseBody.put(DEPARTURE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainCancellationData().getWTTTimestamp()));
        responseBody.put(DIVISION_CODE_FIELD, msg.getTrainCancellationData().getDivision());
        responseBody.put(LOCATION_STANOX_FIELD, msg.getTrainCancellationData().getLocationStanox());
        responseBody.put(CANCELLATION_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainCancellationData().getEventTimestamp()));
        responseBody.put(CANCELLATION_REASON_CODE_FIELD, msg.getTrainCancellationData().getReasonCode());
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainCancellationData().getOriginalTrainID());
        responseBody.put(ORIG_LOCATION_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainCancellationData().getOriginalWTTTimestamp()));
        responseBody.put(CANCELLATION_TYPE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainCancellationData().getTrainCancellationType()).replaceAll("_", " "));

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainMovementMsgV1 to JSON
     *
     * @return A JSON type 0003 message
     */
    @SuppressWarnings("unchecked")
    private String movementToJson(TrainMovementMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_MOVEMENT_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(VARIATION_STATUS_FIELD, msg.getTrainMovementData().getVariationStatus());
        responseBody.put(EVENT_SOURCE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getEventSource()));
        responseBody.put(LINE_INDICATOR_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getLine()));
        responseBody.put(PLATFORM_FIELD, msg.getTrainMovementData().getPlatform());
        responseBody.put(TOC_ID_FIELD, msg.getTrainMovementData().getTOC());
        responseBody.put(REPORTING_STANOX_FIELD, msg.getTrainMovementData().getReportingLocationStanox());
        responseBody.put(EVENT_TYPE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getMovementType()));
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainMovementData().getTrainServiceCode());
        responseBody.put(PLANNED_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getWTTTimestamp()));
        responseBody.put(NEXT_REPORT_RUN_TIME_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getNextReportRunTime()));
        responseBody.put(AUTO_EXPECTED_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isAutoExpectedFlag()));
        responseBody.put(CURRENT_TRAIN_ID_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getCurrentTrainID()));
        responseBody.put(DIVISION_CODE_FIELD, msg.getTrainMovementData().getDivision());
        responseBody.put(TIMETABLE_VARIATION_FIELD, String.valueOf(msg.getTrainMovementData().getTimetableVariation()));
        responseBody.put(DELAY_MONITORING_POINT_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isDelayMonitoringFlag()));
        responseBody.put(ORIGINAL_LOCATION_STANOX_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getOriginalLocationStanox()));
        responseBody.put(CORRECTION_IND_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isRevisionFlag()));
        responseBody.put(PLANNED_EVENT_TYPE_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getPlannedMovementType()));

        XMLGregorianCalendar originalWTTTimestamp = msg.getTrainMovementData().getOriginalWTTTimestamp();

        if (originalWTTTimestamp == null) {
            responseBody.put(ORIGINAL_LOCATION_TIMESTAMP_FIELD, "");
        } else {
            responseBody.put(ORIGINAL_LOCATION_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getOriginalWTTTimestamp()));
        }

        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainMovementData().getTrainFileAddress());
        responseBody.put(LOCATION_STANOX_FIELD, msg.getTrainMovementData().getLocationStanox());
        responseBody.put(ACTUAL_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getEventTimestamp()));
        responseBody.put(DIRECTION_INDICATOR_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getDirection()));
        responseBody.put(ROUTE_FIELD, msg.getTrainMovementData().getRoute());
        responseBody.put(NEXT_REPORT_STANOX_FIELD, msg.getTrainMovementData().getNextLocationStanox());
        responseBody.put(OFFROUTE_INDICATOR_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isOffRouteFlag()));
        responseBody.put(GBTT_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getGBTTTimestamp()));
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainMovementData().getOriginalTrainID());
        responseBody.put(TRAIN_TERMINATED_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isTerminatedFlag()));

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainReinstatementMsgV1 to JSON
     *
     * @return A JSON type 0005 message
     */
    @SuppressWarnings("unchecked")
    private String reinstatementToJson(TrainReinstatementMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_REINSTATEMENT_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainReinstatementData().getTrainServiceCode());
        responseBody.put(REINSTATEMENT_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainReinstatementData().getEventTimestamp()));
        responseBody.put(ORIGINAL_LOCATION_STANOX_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainReinstatementData().getOriginalLocationStanox()));
        responseBody.put(DEPARTURE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainReinstatementData().getWTTTimestamp()));
        responseBody.put(CURRENT_TRAIN_ID_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainReinstatementData().getCurrentTrainID()));
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainReinstatementData().getOriginalTrainID());
        responseBody.put(ORIGINAL_LOCATION_TIMESTAMP_FIELD, ""); // Unused
        responseBody.put(TOC_ID_FIELD, msg.getTrainReinstatementData().getTOC());
        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainReinstatementData().getTrainFileAddress());
        responseBody.put(DIVISION_CODE_FIELD, msg.getTrainReinstatementData().getDivision());
        responseBody.put(LOCATION_STANOX_FIELD, msg.getTrainReinstatementData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainChangeOriginMsgV1 to JSON
     *
     * @return A JSON type 0006 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeOriginToJson(TrainChangeOriginMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_CHANGE_ORIGIN_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(REASON_CODE_FIELD, msg.getTrainChangeOriginData().getReasonCode());
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainChangeOriginData().getTrainServiceCode());
        responseBody.put(ORIGINAL_LOCATION_STANOX_FIELD, msg.getTrainChangeOriginData().getOriginalLocationStanox());
        responseBody.put(DEPARTURE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeOriginData().getWTTTimestamp()));
        responseBody.put(CURRENT_TRAIN_ID_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainChangeOriginData().getCurrentTrainID()));
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainChangeOriginData().getOriginalTrainID());
        responseBody.put(ORIGINAL_LOCATION_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeOriginData().getOriginalWTTTimestamp()));
        responseBody.put(TOC_ID_FIELD, msg.getTrainChangeOriginData().getTOC());
        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainChangeOriginData().getTrainFileAddress());
        responseBody.put(COO_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeOriginData().getEventTimestamp()));
        responseBody.put(DIVISION_CODE_FIELD, msg.getTrainChangeOriginData().getDivision());
        responseBody.put(LOCATION_STANOX_FIELD, msg.getTrainChangeOriginData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainChangeIdentityV1 to JSON
     *
     * @return A JSON type 0007 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeIdentityToJson(TrainChangeIdentityMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_CHANGE_IDENTITY_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainChangeIdentityData().getTrainServiceCode());
        responseBody.put(CURRENT_TRAIN_ID_FIELD, msg.getTrainChangeIdentityData().getCurrentTrainID());
        responseBody.put(EVENT_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeIdentityData().getEventTimestamp()));
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainChangeIdentityData().getOriginalTrainID());
        responseBody.put(REVISED_TRAIN_ID_FIELD, msg.getTrainChangeIdentityData().getRevisedTrainID());
        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainChangeIdentityData().getTrainFileAddress());

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainChangeLocationMsgV1 to JSON
     *
     * @return A JSON type 0008 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeLocationToJson(TrainChangeLocationMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put(MSG_TYPE_FIELD, TRAIN_CHANGE_LOCATION_MSG_TYPE);
        responseHeader.put(MSG_QUEUE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put(ORIGINAL_DATA_SOURCE_FIELD, msg.getSender().getComponent());
        responseHeader.put(USER_ID_FIELD, msg.getSender().getUserID());
        responseHeader.put(SOURCE_DEV_ID_FIELD, msg.getSender().getSessionID());
        responseHeader.put(SOURCE_SYSTEM_ID_FIELD, msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put(TRAIN_SERVICE_CODE_FIELD, msg.getTrainChangeLocationData().getTrainServiceCode());
        responseBody.put(ORIGINAL_LOCATION_STANOX_FIELD, msg.getTrainChangeLocationData().getOriginalLocationStanox());
        responseBody.put(DEPARTURE_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeLocationData().getWTTTimestamp()));
        responseBody.put(CURRENT_TRAIN_ID_FIELD, MessageConverterHelper.emptyIfNull(msg.getTrainChangeLocationData().getCurrentTrainID()));
        responseBody.put(EVENT_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeLocationData().getEventTimestamp()));
        responseBody.put(TRAIN_ID_FIELD, msg.getTrainChangeLocationData().getOriginalTrainID());
        responseBody.put(ORIGINAL_LOCATION_TIMESTAMP_FIELD, MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeLocationData().getOriginalWTTTimestamp()));
        responseBody.put(TRAIN_FILE_ADDRESS_FIELD, msg.getTrainChangeLocationData().getTrainFileAddress());
        responseBody.put(LOCATION_STANOX_FIELD, msg.getTrainChangeLocationData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put(HEADER_FIELD, responseHeader);
        response.put(BODY_FIELD, responseBody);

        return response.toString();

    }

}
