package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 */
public class HelloRoute2 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("stream:in?promptMessage=Enter : ")
      .to("stream:out");
  }

}
