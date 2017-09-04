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
public class TrustMessageConverter implements Processor {

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
     * @return A JSON type 001 message
     */
    @SuppressWarnings("unchecked")
    private String activationToJson(TrainActivationMsgV1 msg) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0001");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("schedule_source", MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getScheduleSource()));
        responseBody.put("train_file_address", msg.getTrainActivationData().getTrainFileAddress());
        responseBody.put("schedule_end_date", dateFormat.format(msg.getTrainActivationData().getScheduleEndTimestamp().toGregorianCalendar().getTime()));
        responseBody.put("train_id", msg.getTrainActivationData().getOriginalTrainID());
        responseBody.put("tp_origin_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainActivationData().getTrainPlanOriginTimestamp()));
        responseBody.put("creation_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseBody.put("tp_origin_stanox", MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getTrainPlanOrigin()));
        responseBody.put("origin_dep_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainActivationData().getWTTTimestamp()));
        responseBody.put("train_service_code", msg.getTrainActivationData().getTrainServiceCode());
        responseBody.put("toc_id", msg.getTrainActivationData().getTOC());
        responseBody.put("d1266_record_number", msg.getTrainActivationData().getTOPSUID());
        responseBody.put("train_call_type", MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getEventSource()));
        responseBody.put("train_uid", msg.getTrainActivationData().getUIDNumber());
        responseBody.put("train_call_mode", msg.getTrainActivationData().getTrainCallMode());
        responseBody.put("schedule_type", MessageConverterHelper.emptyIfNull(msg.getTrainActivationData().getScheduleType()));
        responseBody.put("sched_origin_stanox", msg.getTrainActivationData().getLocationStanox()); // CHECK
        responseBody.put("schedule_wtt_id", msg.getTrainActivationData().getScheduledWTTID());
        responseBody.put("schedule_start_date", dateFormat.format(msg.getTrainActivationData().getScheduleStartTimestamp().toGregorianCalendar().getTime()));

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainCancellationMsgV1 message to JSON
     *
     * @return A JSON type 002 message
     */
    @SuppressWarnings("unchecked")
    private String cancellationToJson(TrainCancellationMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0002");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_file_address", msg.getTrainCancellationData().getTrainFileAddress());
        responseBody.put("train_service_code", msg.getTrainCancellationData().getTrainServiceCode());
        responseBody.put("orig_loc_stanox", msg.getTrainCancellationData().getOriginStanox());
        responseBody.put("toc_id", msg.getTrainCancellationData().getTOC());
        responseBody.put("dep_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainCancellationData().getWTTTimestamp()));
        responseBody.put("division_code", msg.getTrainCancellationData().getDivision());
        responseBody.put("loc_stanox", msg.getTrainCancellationData().getLocationStanox());
        responseBody.put("canx_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainCancellationData().getEventTimestamp()));
        responseBody.put("canx_reason_code", msg.getTrainCancellationData().getReasonCode());
        responseBody.put("train_id", msg.getTrainCancellationData().getOriginalTrainID());
        responseBody.put("orig_loc_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainCancellationData().getOriginalWTTTimestamp()));
        responseBody.put("canx_type", MessageConverterHelper.emptyIfNull(msg.getTrainCancellationData().getTrainCancellationType()).replaceAll("_", " "));

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainMovementMsgV1 to JSON
     *
     * @return A JSON type 003 message
     */
    @SuppressWarnings("unchecked")
    private String movementToJson(TrainMovementMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0003");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("variation_status", msg.getTrainMovementData().getVariationStatus());
        responseBody.put("event_source", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getEventSource()));
        responseBody.put("line_ind", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getLine()));
        responseBody.put("platform", msg.getTrainMovementData().getPlatform());
        responseBody.put("toc_id", msg.getTrainMovementData().getTOC());
        responseBody.put("reporting_stanox", msg.getTrainMovementData().getReportingLocationStanox());
        responseBody.put("event_type", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getMovementType()));
        responseBody.put("train_service_code", msg.getTrainMovementData().getTrainServiceCode());
        responseBody.put("planned_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getWTTTimestamp()));
        responseBody.put("next_report_run_time", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getNextReportRunTime()));
        responseBody.put("auto_expected", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isAutoExpectedFlag()));
        responseBody.put("current_train_id", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getCurrentTrainID()));
        responseBody.put("division_code", msg.getTrainMovementData().getDivision());
        responseBody.put("timetable_variation", String.valueOf(msg.getTrainMovementData().getTimetableVariation()));
        responseBody.put("delay_monitoring_point", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isDelayMonitoringFlag()));
        responseBody.put("original_loc_stanox", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getOriginalLocationStanox()));
        responseBody.put("correction_ind", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isRevisionFlag()));
        responseBody.put("planned_event_type", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getPlannedMovementType()));

        XMLGregorianCalendar originalWTTTimestamp = msg.getTrainMovementData().getOriginalWTTTimestamp();

        if (originalWTTTimestamp == null) {
            responseBody.put("original_loc_timestamp", "");
        } else {
            responseBody.put("original_loc_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getOriginalWTTTimestamp()));
        }

        responseBody.put("train_file_address", msg.getTrainMovementData().getTrainFileAddress());
        responseBody.put("loc_stanox", msg.getTrainMovementData().getLocationStanox());
        responseBody.put("actual_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getEventTimestamp()));
        responseBody.put("direction_ind", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().getDirection()));
        responseBody.put("route", msg.getTrainMovementData().getRoute());
        responseBody.put("next_report_stanox", msg.getTrainMovementData().getNextLocationStanox());
        responseBody.put("offroute_ind", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isOffRouteFlag()));
        responseBody.put("gbtt_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainMovementData().getGBTTTimestamp()));
        responseBody.put("train_id", msg.getTrainMovementData().getOriginalTrainID());
        responseBody.put("train_terminated", MessageConverterHelper.emptyIfNull(msg.getTrainMovementData().isTerminatedFlag()));

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainReinstatementMsgV1 to JSON
     *
     * @return A JSON type 005 message
     */
    @SuppressWarnings("unchecked")
    private String reinstatementToJson(TrainReinstatementMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0005");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_service_code", msg.getTrainReinstatementData().getTrainServiceCode());
        responseBody.put("reinstatement_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainReinstatementData().getEventTimestamp()));
        responseBody.put("original_loc_stanox", MessageConverterHelper.emptyIfNull(msg.getTrainReinstatementData().getOriginalLocationStanox()));
        responseBody.put("dep_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainReinstatementData().getWTTTimestamp()));
        responseBody.put("current_train_id", MessageConverterHelper.emptyIfNull(msg.getTrainReinstatementData().getCurrentTrainID()));
        responseBody.put("train_id", msg.getTrainReinstatementData().getOriginalTrainID());
        responseBody.put("original_loc_timestamp", ""); // Unused
        responseBody.put("toc_id", msg.getTrainReinstatementData().getTOC());
        responseBody.put("train_file_address", msg.getTrainReinstatementData().getTrainFileAddress());
        responseBody.put("division_code", msg.getTrainReinstatementData().getDivision());
        responseBody.put("loc_stanox", msg.getTrainReinstatementData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainChangeOriginMsgV1 to JSON
     *
     * @return A JSON type 006 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeOriginToJson(TrainChangeOriginMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0006");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("reason_code", msg.getTrainChangeOriginData().getReasonCode());
        responseBody.put("train_service_code", msg.getTrainChangeOriginData().getTrainServiceCode());
        responseBody.put("original_loc_stanox", msg.getTrainChangeOriginData().getOriginalLocationStanox());
        responseBody.put("dep_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeOriginData().getWTTTimestamp()));
        responseBody.put("current_train_id", MessageConverterHelper.emptyIfNull(msg.getTrainChangeOriginData().getCurrentTrainID()));
        responseBody.put("train_id", msg.getTrainChangeOriginData().getOriginalTrainID());
        responseBody.put("original_loc_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeOriginData().getOriginalWTTTimestamp()));
        responseBody.put("toc_id", msg.getTrainChangeOriginData().getTOC());
        responseBody.put("train_file_address", msg.getTrainChangeOriginData().getTrainFileAddress());
        responseBody.put("coo_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeOriginData().getEventTimestamp()));
        responseBody.put("division_code", msg.getTrainChangeOriginData().getDivision());
        responseBody.put("loc_stanox", msg.getTrainChangeOriginData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainChangeIdentityV1 to JSON
     *
     * @return A JSON type 007 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeIdentityToJson(TrainChangeIdentityMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0007");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_service_code", msg.getTrainChangeIdentityData().getTrainServiceCode());
        responseBody.put("current_train_id", msg.getTrainChangeIdentityData().getCurrentTrainID());
        responseBody.put("event_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeIdentityData().getEventTimestamp()));
        responseBody.put("train_id", msg.getTrainChangeIdentityData().getOriginalTrainID());
        responseBody.put("revised_train_id", msg.getTrainChangeIdentityData().getRevisedTrainID());
        responseBody.put("train_file_address", msg.getTrainChangeIdentityData().getTrainFileAddress());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

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
        responseHeader.put("msg_type", "0008");
        responseHeader.put("msg_queue_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTimestamp()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_service_code", msg.getTrainChangeLocationData().getTrainServiceCode());
        responseBody.put("original_loc_stanox", msg.getTrainChangeLocationData().getOriginalLocationStanox());
        responseBody.put("dep_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeLocationData().getWTTTimestamp()));
        responseBody.put("current_train_id", MessageConverterHelper.emptyIfNull(msg.getTrainChangeLocationData().getCurrentTrainID()));
        responseBody.put("event_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeLocationData().getEventTimestamp()));
        responseBody.put("train_id", msg.getTrainChangeLocationData().getOriginalTrainID());
        responseBody.put("original_loc_timestamp", MessageConverterHelper.timestampToEpochSecs(msg.getTrainChangeLocationData().getOriginalWTTTimestamp()));
        responseBody.put("train_file_address", msg.getTrainChangeLocationData().getTrainFileAddress());
        responseBody.put("loc_stanox", msg.getTrainChangeLocationData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

}
