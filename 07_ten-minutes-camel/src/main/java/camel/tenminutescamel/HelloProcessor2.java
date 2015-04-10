package camel.tenminutescamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author tanabe
 */
public class HelloProcessor2 implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    String body = exchange.getIn().getBody(String.class);

    if ("".equals(body)) {
      System.err.println("リトライしたけどだめでした");
      throw new IllegalArgumentException("empty value");
    }

    body = "Hello, " + body;
    exchange.getIn().setBody(body);
  }

}
