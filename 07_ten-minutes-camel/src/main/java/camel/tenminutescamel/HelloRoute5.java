package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 */
public class HelloRoute5 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("stream:in?promptMessage=Enter : ").routeId("HelloRoute5")
      .process(new HelloProcessor2())
      .to("stream:out");
  }

}
