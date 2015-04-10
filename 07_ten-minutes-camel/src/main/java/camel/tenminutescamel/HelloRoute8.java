package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 */
public class HelloRoute8 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("direct:route2")
      .to("log:route2")
      .throwException(new Exception("test error"));
  }

}
