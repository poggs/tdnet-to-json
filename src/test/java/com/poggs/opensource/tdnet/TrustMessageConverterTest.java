package com.poggs.opensource.tdnet;

import com.poggs.opensource.tdnet.trust.TrustMessageConverter;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the TrustMessageConverter class
 */
public class TrustMessageConverterTest extends CamelTestSupport {

    @SuppressWarnings("unused")
    @EndpointInject(uri="mock:result")
    private MockEndpoint resultEndpoint;

    @SuppressWarnings("unused")
    @EndpointInject(uri="direct:start")
    private ProducerTemplate template;

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                Processor trustMessageProcessor = new TrustMessageConverter();
                from("direct:start").process(trustMessageProcessor).to("mock:result");
            }
        };
    }

    @Test
    public void convertsActivationMessage() throws Exception {

        final String expectedMessageString = "{\"header\":{\"msg_type\":\"0001\",\"source_dev_id\":\"\",\"user_id\":\"\",\"original_data_source\":\"TSIA\",\"msg_queue_timestamp\":\"1457660071000\",\"source_system_id\":\"TRUST\"},\"body\":{\"schedule_source\":\"C\",\"train_file_address\":\"\",\"schedule_end_date\":\"2016-05-13\",\"train_id\":\"496P40C311\",\"tp_origin_timestamp\":\"1457667240000\",\"creation_timestamp\":\"1457660071000\",\"tp_origin_stanox\":\"\",\"origin_dep_timestamp\":\"1457667240000\",\"train_service_code\":\"55460480\",\"toc_id\":\"54\",\"d1266_record_number\":\"00000\",\"train_call_type\":\"AUTOMATIC\",\"train_uid\":\"H61215\",\"train_call_mode\":\"NORMAL\",\"schedule_type\":\"O\",\"sched_origin_stanox\":\"49413\",\"schedule_wtt_id\":\"6P40C\",\"schedule_start_date\":\"2015-12-14\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TrainActivationMsgV1 xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-11T01:34:31-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-11T01:34:31-00:00@trmv.networkrail.co.uk\" ><eai:Sender organisation=\"Network Rail\" application=\"TRUST\" component=\"TSIA\" userID=\"\" sessionID=\"\" /><TrainActivationData><OriginalTrainID>496P40C311</OriginalTrainID><EventTimestamp>2016-03-11T01:34:31-00:00</EventTimestamp><LocationStanox>49413</LocationStanox><WTTTimestamp>2016-03-11T03:34:00-00:00</WTTTimestamp><UIDNumber>H61215</UIDNumber><ScheduleStartTimestamp>2015-12-14T00:00:00-00:00</ScheduleStartTimestamp><ScheduleEndTimestamp>2016-05-13T00:00:00-00:00</ScheduleEndTimestamp><ScheduleSource>C</ScheduleSource><ScheduleType>O</ScheduleType><ScheduledWTTID>6P40C</ScheduledWTTID><TOPSUID>00000</TOPSUID><TrainPlanOriginTimestamp>2016-03-11T03:34:00-00:00</TrainPlanOriginTimestamp><EventSource>AUTOMATIC</EventSource><TrainCallMode>NORMAL</TrainCallMode><TOC>54</TOC><TrainServiceCode>55460480</TrainServiceCode><TrainFileAddress></TrainFileAddress></TrainActivationData></TrainActivationMsgV1>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();

        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void convertsCancellationMessage() throws Exception {

        final String expectedMessageString = "{\"header\":{\"msg_type\":\"0002\",\"source_dev_id\":\"LYJ8\",\"user_id\":\"#QGP0146\",\"original_data_source\":\"TRUST DA\",\"msg_queue_timestamp\":\"1457283656000\",\"source_system_id\":\"TRUST\"},\"body\":{\"train_file_address\":\"\",\"train_service_code\":\"21724000\",\"orig_loc_stanox\":\"54291\",\"toc_id\":\"88\",\"dep_timestamp\":\"1457280060000\",\"division_code\":\"88\",\"loc_stanox\":\"54311\",\"canx_timestamp\":\"1457280060000\",\"canx_reason_code\":\"TG\",\"train_id\":\"532J43MQ06\",\"orig_loc_timestamp\":\"1457279790000\",\"canx_type\":\"OUT OF PLAN\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TrainCancellationMsgV1 xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-06T17:00:56-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-06T17:00:56-00:00@trmv.networkrail.co.uk\" ><eai:Sender organisation=\"Network Rail\" application=\"TRUST\" component=\"TRUST DA\" userID=\"#QGP0146\" sessionID=\"LYJ8\" /><TrainCancellationData><OriginalTrainID>532J43MQ06</OriginalTrainID><EventTimestamp>2016-03-06T16:01:00-00:00</EventTimestamp><LocationStanox>54311</LocationStanox><WTTTimestamp>2016-03-06T16:01:00-00:00</WTTTimestamp><OriginStanox>54291</OriginStanox><OriginalWTTTimestamp>2016-03-06T15:56:30-00:00</OriginalWTTTimestamp><TrainCancellationType>OUT OF PLAN</TrainCancellationType><TrainServiceCode>21724000</TrainServiceCode><ReasonCode>TG</ReasonCode><Division>88</Division><TOC>88</TOC><TrainFileAddress></TrainFileAddress></TrainCancellationData></TrainCancellationMsgV1>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void convertsMovementMessage() throws Exception {

        final String expectedMessageString = "{\"header\":{\"msg_type\":\"0003\",\"source_dev_id\":\"\",\"user_id\":\"\",\"original_data_source\":\"SMART\",\"msg_queue_timestamp\":\"1457935117000\",\"source_system_id\":\"TRUST\"},\"body\":{\"event_type\":\"ARRIVAL\",\"gbtt_timestamp\":\"1457935200000\",\"original_loc_stanox\":\"\",\"planned_timestamp\":\"1457935170000\",\"timetable_variation\":\"0\",\"original_loc_timestamp\":\"\",\"current_train_id\":\"\",\"delay_monitoring_point\":\"true\",\"next_report_run_time\":\"1\",\"reporting_stanox\":\"52705\",\"actual_timestamp\":\"1457935140000\",\"correction_ind\":\"false\",\"event_source\":\"AUTOMATIC\",\"train_file_address\":\"\",\"platform\":\" 1\",\"division_code\":\"79\",\"train_terminated\":\"false\",\"train_id\":\"512B53M414\",\"offroute_ind\":\"false\",\"variation_status\":\"ON TIME\",\"train_service_code\":\"21936004\",\"toc_id\":\"79\",\"loc_stanox\":\"52705\",\"auto_expected\":\"true\",\"direction_ind\":\"UP\",\"route\":\"0\",\"planned_event_type\":\"ARRIVAL\",\"next_report_stanox\":\"52707\",\"line_ind\":\"\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TrainMovementMsgV1 xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-14T05:58:37-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-14T05:58:37-00:00@trmv.networkrail.co.uk\" ><eai:Sender organisation=\"Network Rail\" application=\"TRUST\" component=\"SMART\" userID=\"\" sessionID=\"\" /><TrainMovementData><OriginalTrainID>512B53M414</OriginalTrainID><EventTimestamp>2016-03-14T05:59:00-00:00</EventTimestamp><LocationStanox>52705</LocationStanox><GBTTTimestamp>2016-03-14T06:00:00-00:00</GBTTTimestamp><WTTTimestamp>2016-03-14T05:59:30-00:00</WTTTimestamp><PlannedMovementType>ARRIVAL</PlannedMovementType><MovementType>ARRIVAL</MovementType><EventSource>AUTOMATIC</EventSource><RevisionFlag>false</RevisionFlag><OffRouteFlag>false</OffRouteFlag><Direction>UP</Direction><Platform> 1</Platform><Route>0</Route><TrainServiceCode>21936004</TrainServiceCode><Division>79</Division><TOC>79</TOC><TimetableVariation>0</TimetableVariation><VariationStatus>ON TIME</VariationStatus><NextLocationStanox>52707</NextLocationStanox><NextReportRunTime>1</NextReportRunTime><TerminatedFlag>false</TerminatedFlag><DelayMonitoringFlag>true</DelayMonitoringFlag><ReportingLocationStanox>52705</ReportingLocationStanox><AutoExpectedFlag>true</AutoExpectedFlag><TrainFileAddress></TrainFileAddress></TrainMovementData></TrainMovementMsgV1>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    // UnidentifiedTrainMovementMsgV1 messages have never been seen

    @Test
    public void convertsReinstatementMessage() throws Exception {

        final String expectedMessageString = "{\"header\":{\"msg_type\":\"0005\",\"source_dev_id\":\"LYJ7\",\"user_id\":\"#QLP0011\",\"original_data_source\":\"TRUST DA\",\"msg_queue_timestamp\":\"1457980235000\",\"source_system_id\":\"TRUST\"},\"body\":{\"current_train_id\":\"\",\"original_loc_timestamp\":\"\",\"train_file_address\":\"\",\"train_service_code\":\"13574515\",\"toc_id\":\"60\",\"dep_timestamp\":\"1457981460000\",\"division_code\":\"60\",\"loc_stanox\":\"06222\",\"train_id\":\"062W52MX14\",\"original_loc_stanox\":\"\",\"reinstatement_timestamp\":\"1457980200000\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TrainReinstatementMsgV1 xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-14T18:30:35-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-14T18:30:35-00:00@trmv.networkrail.co.uk\" ><eai:Sender organisation=\"Network Rail\" application=\"TRUST\" component=\"TRUST DA\" userID=\"#QLP0011\" sessionID=\"LYJ7\" /><TrainReinstatementData><OriginalTrainID>062W52MX14</OriginalTrainID><EventTimestamp>2016-03-14T18:30:00-00:00</EventTimestamp><LocationStanox>06222</LocationStanox><WTTTimestamp>2016-03-14T18:51:00-00:00</WTTTimestamp><TrainServiceCode>13574515</TrainServiceCode><Division>60</Division><TOC>60</TOC><TrainFileAddress></TrainFileAddress></TrainReinstatementData></TrainReinstatementMsgV1>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void convertsChangeOfOriginMessage() throws Exception {

        final String expectedMessageString = "{\"header\":{\"msg_type\":\"0006\",\"source_dev_id\":\"VXNJ\",\"user_id\":\"#QHP0001\",\"original_data_source\":\"SDR\",\"msg_queue_timestamp\":\"1456917634000\",\"source_system_id\":\"TRUST\"},\"body\":{\"reason_code\":\"\",\"current_train_id\":\"\",\"original_loc_timestamp\":\"1456839840000\",\"train_file_address\":\"\",\"train_service_code\":\"22215003\",\"toc_id\":\"30\",\"dep_timestamp\":\"1456839840000\",\"coo_timestamp\":\"1456917600000\",\"division_code\":\"30\",\"loc_stanox\":\"87625\",\"train_id\":\"879D33MN01\",\"original_loc_stanox\":\"87645\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TrainChangeOriginMsgV1 xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-02T11:20:34-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-02T11:20:34-00:00@trmv.networkrail.co.uk\" ><eai:Sender organisation=\"Network Rail\" application=\"TRUST\" component=\"SDR\" userID=\"#QHP0001\" sessionID=\"VXNJ\" /><TrainChangeOriginData><OriginalTrainID>879D33MN01</OriginalTrainID><EventTimestamp>2016-03-02T11:20:00-00:00</EventTimestamp><LocationStanox>87625</LocationStanox><WTTTimestamp>2016-03-01T13:44:00-00:00</WTTTimestamp><OriginalLocationStanox>87645</OriginalLocationStanox><OriginalWTTTimestamp>2016-03-01T13:44:00-00:00</OriginalWTTTimestamp><TrainServiceCode>22215003</TrainServiceCode><ReasonCode></ReasonCode><Division>30</Division><TOC>30</TOC><TrainFileAddress></TrainFileAddress></TrainChangeOriginData></TrainChangeOriginMsgV1>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void convertsChangeOfIdentityMessage() throws Exception {

        final String expectedMessageString = "{\"header\":{\"msg_type\":\"0007\",\"source_dev_id\":\"X282230\",\"user_id\":\"\",\"original_data_source\":\"TOPS\",\"msg_queue_timestamp\":\"1456825508000\",\"source_system_id\":\"TRUST\"},\"body\":{\"current_train_id\":\"890M45CA01\",\"train_file_address\":\"CQR\",\"train_service_code\":\"57610312\",\"revised_train_id\":\"896M45CA01\",\"train_id\":\"896M45CA01\",\"event_timestamp\":\"1456825463000\"}}";

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TrainChangeIdentityMsgV1 xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-01T09:45:08-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-01T09:45:08-00:00@trmv.networkrail.co.uk\" ><eai:Sender organisation=\"Network Rail\" application=\"TRUST\" component=\"TOPS\" userID=\"\" sessionID=\"X282230\" /><TrainChangeIdentityData><OriginalTrainID>896M45CA01</OriginalTrainID><CurrentTrainID>890M45CA01</CurrentTrainID><EventTimestamp>2016-03-01T09:44:23-00:00</EventTimestamp><RevisedTrainID>896M45CA01</RevisedTrainID><TrainServiceCode>57610312</TrainServiceCode><TrainFileAddress>CQR</TrainFileAddress></TrainChangeIdentityData></TrainChangeIdentityMsgV1>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();

        Exchange firstExchange = list.get(0);
        Message firstMessage = firstExchange.getIn();

        JSONParser parser = new JSONParser();
        JSONObject expectedMessage = (JSONObject) parser.parse(expectedMessageString);
        JSONObject actualMessage = (JSONObject) parser.parse(firstMessage.getBody().toString());

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void producesNoOutputForInvalidMessage() throws Exception {

        template.send("direct:start", new Processor() {

            final String msgIn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><UnhandledXmlMessage xmlns=\"http://xml.networkrail.co.uk/ns/2008/Train\" xsi:schemaLocation=\"http://xml.networkrail.co.uk/ns/2008/Train itm_train_movement_messaging_v1.12.xsd\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:eai=\"http://xml.networkrail.co.uk/ns/2008/EAI\" xmlns:nr=\"http://xml.networkrail.co.uk/ns/2008/NR\" classification=\"industry\" timestamp=\"2016-03-01T09:45:08-00:00\" owner=\"Network Rail\" originMsgId=\"2016-03-01T09:45:08-00:00@trmv.networkrail.co.uk\" ></UnhandledXmlMessage>";

            public void process(Exchange exchange) {
                Message in = exchange.getIn();
                in.setBody(msgIn);
            }

        });

        assertMockEndpointsSatisfied();

        List<Exchange> list = resultEndpoint.getReceivedExchanges();
        assertEquals(0, list.size());

    }

}