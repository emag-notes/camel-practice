package camel.calcapi;

import org.apache.camel.builder.RouteBuilder;

/**
 * HTTP 受信
 * @author tanabe
 */
public class HttpRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("jetty:http://0.0.0.0:5555/")
      .to("log:in?showAll=true&multiline=true")
      .to(CalcAddRoute.IN)
      .to("log:out?showAll=true&multiline=true");
  }

}
