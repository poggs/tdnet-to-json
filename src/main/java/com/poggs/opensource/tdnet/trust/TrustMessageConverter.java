package com.poggs.opensource.tdnet.trust;

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

        if(msgOut.getClass() == TrainActivationMsgV1.class) {
            response = activationToJson((TrainActivationMsgV1) msgOut);
        } else if(msgOut.getClass() == TrainCancellationMsgV1.class) {
            response = cancellationToJson((TrainCancellationMsgV1) msgOut);
        } else if(msgOut.getClass() == TrainMovementMsgV1.class) {
            response = movementToJson((TrainMovementMsgV1) msgOut);
        } else if(msgOut.getClass() == TrainReinstatementMsgV1.class) {
            response = reinstatementToJson((TrainReinstatementMsgV1) msgOut);
        } else if(msgOut.getClass() == TrainChangeOriginMsgV1.class) {
            response = trainChangeOriginToJson((TrainChangeOriginMsgV1) msgOut);
        } else if(msgOut.getClass() == TrainChangeIdentityMsgV1.class) {
            response = trainChangeIdentityToJson((TrainChangeIdentityMsgV1) msgOut);
        }

        exchange.getIn().setBody(response);

    }

    /**
     * Convert a TrainActivationV1 message to JSON
     * @return A JSON type 001 message
     */
    @SuppressWarnings("unchecked")
    private String activationToJson(TrainActivationMsgV1 msg) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0001");
        responseHeader.put("msg_queue_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("schedule_source", msg.getTrainActivationData().getScheduleSource().toString());
        responseBody.put("train_file_address", msg.getTrainActivationData().getTrainFileAddress());
        responseBody.put("schedule_end_date", dateFormat.format(msg.getTrainActivationData().getScheduleEndTimestamp().toGregorianCalendar().getTime()));
        responseBody.put("train_id", msg.getTrainActivationData().getOriginalTrainID());
        responseBody.put("tp_origin_timestamp", String.valueOf(msg.getTrainActivationData().getTrainPlanOriginTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("creation_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("tp_origin_stanox", msg.getTrainActivationData().getTrainPlanOrigin());
        responseBody.put("origin_dep_timestamp", String.valueOf(msg.getTrainActivationData().getWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("train_service_code", msg.getTrainActivationData().getTrainServiceCode());
        responseBody.put("toc_id", msg.getTrainActivationData().getTOC());
        responseBody.put("d1266_record_number", msg.getTrainActivationData().getTOPSUID());
        responseBody.put("train_call_type", msg.getTrainActivationData().getEventSource().toString());
        responseBody.put("train_uid", msg.getTrainActivationData().getUIDNumber());
        responseBody.put("train_call_mode", msg.getTrainActivationData().getTrainCallMode());
        responseBody.put("schedule_type", msg.getTrainActivationData().getScheduleType().toString());
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
     * @return A JSON type 002 message
     */
    @SuppressWarnings("unchecked")
    private String cancellationToJson(TrainCancellationMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0002");
        responseHeader.put("msg_queue_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_file_address", msg.getTrainCancellationData().getTrainFileAddress());
        responseBody.put("train_service_code", msg.getTrainCancellationData().getTrainServiceCode());
        responseBody.put("orig_loc_stanox", msg.getTrainCancellationData().getOriginStanox());
        responseBody.put("toc_id", msg.getTrainCancellationData().getTOC());
        responseBody.put("dep_timestamp", String.valueOf(msg.getTrainCancellationData().getWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("division_code", msg.getTrainCancellationData().getDivision());
        responseBody.put("loc_stanox", msg.getTrainCancellationData().getLocationStanox());
        responseBody.put("canx_timestamp", String.valueOf(msg.getTrainCancellationData().getEventTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("canx_reason_code", msg.getTrainCancellationData().getReasonCode());
        responseBody.put("train_id", msg.getTrainCancellationData().getOriginalTrainID());
        responseBody.put("orig_loc_timestamp", String.valueOf(msg.getTrainCancellationData().getOriginalWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("canx_type", msg.getTrainCancellationData().getTrainCancellationType().toString().replaceAll("_", " "));

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainMovementMsgV1 to JSON
     * @return A JSON type 003 message
     */
    @SuppressWarnings("unchecked")
    private String movementToJson(TrainMovementMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0003");
        responseHeader.put("msg_queue_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("variation_status", msg.getTrainMovementData().getVariationStatus());
        responseBody.put("event_source", msg.getTrainMovementData().getEventSource().toString());
        responseBody.put("line_ind", msg.getTrainMovementData().getLine());
        responseBody.put("platform", msg.getTrainMovementData().getPlatform());
        responseBody.put("toc_id", msg.getTrainMovementData().getTOC());
        responseBody.put("reporting_stanox", msg.getTrainMovementData().getReportingLocationStanox());
        responseBody.put("event_type", msg.getTrainMovementData().getMovementType().toString());
        responseBody.put("train_service_code", msg.getTrainMovementData().getTrainServiceCode());
        responseBody.put("planned_timestamp", String.valueOf(msg.getTrainMovementData().getWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("next_report_run_time", msg.getTrainMovementData().getNextReportRunTime().toString());
        responseBody.put("auto_expected", msg.getTrainMovementData().isAutoExpectedFlag().toString());
        responseBody.put("current_train_id", msg.getTrainMovementData().getCurrentTrainID());
        responseBody.put("division_code", msg.getTrainMovementData().getDivision());
        responseBody.put("timetable_variation", String.valueOf(msg.getTrainMovementData().getTimetableVariation()));
        responseBody.put("delay_monitoring_point", msg.getTrainMovementData().isDelayMonitoringFlag().toString());
        responseBody.put("original_loc_stanox", msg.getTrainMovementData().getOriginalLocationStanox());
        responseBody.put("correction_ind", msg.getTrainMovementData().isRevisionFlag().toString());
        responseBody.put("planned_event_type", msg.getTrainMovementData().getPlannedMovementType().toString());

        XMLGregorianCalendar originalWTTTimestamp = msg.getTrainMovementData().getOriginalWTTTimestamp();

        if(originalWTTTimestamp == null) {
            responseBody.put("original_loc_timestamp", "");
        } else {
            responseBody.put("original_loc_timestamp", msg.getTrainMovementData().getOriginalWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli());
        }

        responseBody.put("train_file_address", msg.getTrainMovementData().getTrainFileAddress());
        responseBody.put("loc_stanox", msg.getTrainMovementData().getLocationStanox());
        responseBody.put("actual_timestamp", String.valueOf(msg.getTrainMovementData().getEventTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("direction_ind", msg.getTrainMovementData().getDirection().toString());
        responseBody.put("route", msg.getTrainMovementData().getRoute());
        responseBody.put("next_report_stanox", msg.getTrainMovementData().getNextLocationStanox());
        responseBody.put("offroute_ind", msg.getTrainMovementData().isOffRouteFlag().toString());
        responseBody.put("gbtt_timestamp", String.valueOf(msg.getTrainMovementData().getGBTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("train_id", msg.getTrainMovementData().getOriginalTrainID());
        responseBody.put("train_terminated", msg.getTrainMovementData().isTerminatedFlag().toString());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainReinstatementMsgV1 to JSON
     * @return A JSON type 005 message
     */
    @SuppressWarnings("unchecked")
    private String reinstatementToJson(TrainReinstatementMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0005");
        responseHeader.put("msg_queue_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_service_code", msg.getTrainReinstatementData().getTrainServiceCode());
        responseBody.put("reinstatement_timestamp", String.valueOf(msg.getTrainReinstatementData().getEventTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("original_loc_stanox", msg.getTrainReinstatementData().getOriginalLocationStanox());

        XMLGregorianCalendar wttTimestamp = msg.getTrainReinstatementData().getWTTTimestamp();

        if(wttTimestamp == null) {
            responseBody.put("dep_timestamp", "");
        } else {
            responseBody.put("dep_timestamp", String.valueOf(wttTimestamp.toGregorianCalendar().toInstant().toEpochMilli()));
        }

        responseBody.put("current_train_id", msg.getTrainReinstatementData().getCurrentTrainID());
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
     * @return A JSON type 006 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeOriginToJson(TrainChangeOriginMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0006");
        responseHeader.put("msg_queue_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("reason_code", msg.getTrainChangeOriginData().getReasonCode());
        responseBody.put("train_service_code", msg.getTrainChangeOriginData().getTrainServiceCode());
        responseBody.put("original_loc_stanox", msg.getTrainChangeOriginData().getOriginalLocationStanox());
        responseBody.put("dep_timestamp", String.valueOf(msg.getTrainChangeOriginData().getWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("current_train_id", msg.getTrainChangeOriginData().getCurrentTrainID());
        responseBody.put("train_id", msg.getTrainChangeOriginData().getOriginalTrainID());
        responseBody.put("original_loc_timestamp", String.valueOf(msg.getTrainChangeOriginData().getOriginalWTTTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("toc_id", msg.getTrainChangeOriginData().getTOC());
        responseBody.put("train_file_address", msg.getTrainChangeOriginData().getTrainFileAddress());
        responseBody.put("coo_timestamp", String.valueOf(msg.getTrainChangeOriginData().getEventTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("division_code", msg.getTrainChangeOriginData().getDivision());
        responseBody.put("loc_stanox", msg.getTrainChangeOriginData().getLocationStanox());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

    /**
     * Convert a TrainChangeIdentityV1 to JSON
     * @return A JSON type 007 message
     */
    @SuppressWarnings("unchecked")
    private String trainChangeIdentityToJson(TrainChangeIdentityMsgV1 msg) {

        JSONObject responseHeader = new JSONObject();
        responseHeader.put("msg_type", "0007");
        responseHeader.put("msg_queue_timestamp", String.valueOf(msg.getTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseHeader.put("original_data_source", msg.getSender().getComponent());
        responseHeader.put("user_id", msg.getSender().getUserID());
        responseHeader.put("source_dev_id", msg.getSender().getSessionID());
        responseHeader.put("source_system_id", msg.getSender().getApplication());

        JSONObject responseBody = new JSONObject();
        responseBody.put("train_service_code", msg.getTrainChangeIdentityData().getTrainServiceCode());
        responseBody.put("current_train_id", msg.getTrainChangeIdentityData().getCurrentTrainID());
        responseBody.put("event_timestamp", String.valueOf(msg.getTrainChangeIdentityData().getEventTimestamp().toGregorianCalendar().toInstant().toEpochMilli()));
        responseBody.put("train_id", msg.getTrainChangeIdentityData().getOriginalTrainID());
        responseBody.put("revised_train_id", msg.getTrainChangeIdentityData().getRevisedTrainID());
        responseBody.put("train_file_address", msg.getTrainChangeIdentityData().getTrainFileAddress());

        JSONObject response = new JSONObject();
        response.put("header", responseHeader);
        response.put("body", responseBody);

        return response.toString();

    }

}
