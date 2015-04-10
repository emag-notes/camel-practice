package camel.tenminutescamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * 独自実装は org.apache.camel.Processor を実装する
 * @author tanabe
 */
public class HelloProcessor1 implements Processor {

  // Exchange はルート=ベルトコンベアを流れる箱
  @Override
  public void process(Exchange exchange) throws Exception {
    // getIn() は流れてきたメッセージ
    String body = exchange.getIn().getBody(String.class);
    body = "Hello, " + body; // ボディを加工して、
    exchange.getIn().setBody(body); // 箱に入れておく
  }

}
