package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 */
public class HelloRoute7 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    onException(Exception.class).maximumRedeliveries(2)
      .handled(true)
      .setBody().constant("something wrong")
      .to("stream:out");

    from("stream:in?promptMessage=Enter : ").routeId("HelloRoute")
      .process(new HelloProcessor2())
      .to("direct:route2")
      .to("stream:out");
  }

}
