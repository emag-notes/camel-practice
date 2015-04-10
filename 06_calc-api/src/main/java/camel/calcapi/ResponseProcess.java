package camel.calcapi;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.Map;

/**
 * 結果を Map に入れる処理
 * @author tanabe
 */
public class ResponseProcess implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    Message in = exchange.getIn();
    Map<String, Object> map = new HashMap<>();
    map.put("result", in.getHeader("result"));
    in.setBody(map);
  }
}
