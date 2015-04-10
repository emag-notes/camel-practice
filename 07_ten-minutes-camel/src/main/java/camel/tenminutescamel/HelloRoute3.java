package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 */
public class HelloRoute3 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("stream:in?promptMessage=Enter : ")
      .process(new HelloProcessor1()) // 独自 Processor は process で呼び出す
      .to("stream:out");
  }

}
