# TD.net to JSON

This Camel component will convert TD.net messages in XML format in to a lightweight JSON format.

If you don't know what TD.net is, or you don't have access, then this component is not for you.

The following message types are supported:

* Train Describer - CA, CB, CC, CT, SF, SG and SH

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