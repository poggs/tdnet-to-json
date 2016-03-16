# TD.net to JSON

This Camel component will convert TD.net messages in XML format in to a lightweight JSON format.

If you don't know what TD.net is, or you don't have access, then this component is not for you.

The following message types are supported:

* Train Describer - CA, CB, CC, CT, SF, SG and SH
* Train Movement - all message types (excluding UnidentifiedTrainMovement)

## Usage

### Spring XML

    <route id="testRoute">
      <from uri="queue:input"/>
      <to uri="tdToJson"/>
      <to uri="queue:output"/>
      </split>
    </route>

### Fluent Builders

    RouteBuilder builder = new RouteBuilder() {
      public void configure() {
        Processor tdMessageProcessor = new TdMessageConverter();
        from("queue:a")
            .process(tdMessageProcessor))
            .to("queue:b");
      }
    }

## Train Movement data mapping

Train movement data is converted to the same JSON format as used by the Network Rail Data Feeds platform, making it easy to migrate between platforms.

### TrainActivationMsgV1

JSON message type '0001'

| XML                      | JSON                 | Type      |
|--------------------------|----------------------|-----------|
| OriginalTrainId          | train_id             | String    |
| EventTimestamp           | creation_timestamp   | Timestamp |
| LocationStanox           | sched_origin_stanox  | String    |
| WTTTimestamp             | origin_dep_timestamp | Timestamp |
| UIDNumber                | train_uid            | String    |
| ScheduleStartTimestamp   | schedule_start_date  | Timestamp |
| ScheduleEndTimestamp     | schedule_end_date    | Timestamp |
| ScheduleSource           | schedule_source      | String    |
| ScheduleType             | schedule_type        | String    |
| ScheduledWTTID           | schedule_wtt_id      | String    |
| TOPSUID                  | d1266_record_number  | String    |
| TrainPlanOrigin          | tp_origin_stanox     | String    |
| TrainPlanOriginTimestamp | tp_origin_timestamp  | Timestamp |
| EventSource              | train_call_type      | String    |
| TrainCallMode            | train_call_mode      | String    |
| TOC                      | toc_id               | String    |
| TrainServiceCode         | train_service_code   | String    |
| TrainFileAddress         | train_file_address   | String    |

**NOTE:** The *TrainPlanOriginTimestamp* field in XML is incorrectly sent as a date in Open Data, whereas it is converted to a Timestamp here.

### TrainCancellationMsgV1

JSON message type '0002'

| XML                   | JSON               | Type      |
|-----------------------|--------------------|-----------|
| OriginalTrainID       | train_id           | String    |
| EventTimestamp        | canx_timestamp     | Timestamp |
| LocationStanox        | loc_stanox         | String    |
| WTTTimestamp          | dep_timestamp      | Timestamp |
| OriginStanox          | orig_loc_stanox    | String    |
| OriginalWTTTimestamp  | orig_loc_timestamp | Timestamp |
| TrainCancellationType | canx_type          | String    |
| TrainServiceCode      | train_service_code | String    |
| ReasonCode            | canx_reason_code   | String    |
| Division              | division_code      | String    |
| TOC                   | toc_id             | String    |
| TrainFileAddress      | train_file_address | String    |

### TrainMovementMsgV1

JSON message type '0003'

| XML                     | JSON                   | Type      |
|-------------------------|------------------------|-----------|
| OriginalTrainID         | train_id               | String    |
| EventTimestamp          | actual_timestamp       | Timestamp |
| LocationStanox          | loc_stanox             | String    |
| GBTTTimestamp           | gbtt_timestamp         | Timestamp |
| WTTTimestamp            | planned_timestamp      | Timestamp |
| PlannedMovementType     | planned_event_type     | String    |
| MovementType            | event_type             | String    |
| EventSource             | event_source           | Boolean   |
| RevisionFlag            | correction_ind         | Boolean   |
| OffRouteFlag            | offroute_ind           | Boolean   |
| Direction               | direction_ind          | String    |
| Platform                | platform               | String    |
| Route                   | route                  | String    |
| TrainServiceCode        | train_service_code     | String    |
| Division                | division_code          | String    |
| TOC                     | toc_id                 | String    |
| TimetableVariation      | timetable_variation    | String    |
| VariationStatus         | variation_status       | String    |
| NextLocationStanox      | next_report_stanox     | String    |
| NextReportRunTime       | next_report_run_time   | String    |
| TerminatedFlag          | train_terminated       | Boolean   |
| DelayMonitoringFlag     | delay_monitoring_point | Boolean   |
| ReportingLocationStanox | reporting_stanox       | String    |
| AutoExpectedFlag        | auto_expected          | Boolean   |
| TrainFileAddress        | train_file_address     | String    |

## TrainReinstatementMsgV1

| XML                     | JSON                    | Type      |
|-------------------------|-------------------------|-----------|
| OriginalTrainID         | train_id                | String    |
| EventTimestamp          | reinstatement_timestamp | Timestamp |
| LocationStanox          | loc_stanox              | String    |
| WTTTimestamp            | dep_timestamp           | Timestamp |
| TrainServiceCode        | train_service_code      | String    |
| Division                | division_code           | String    |
| TOC                     | toc                     | String    |
| TrainFileAddress        | train_file_address      | String    |

**NOTE:** The *original_loc_timestamp* and *orig_loc_stanox* fields in Open Data JSON is not mapped to an XML field and has been excluded.

