package camel.calcapi;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.ArrayList;

/**
 * 配列要素を足し合わせる
 * @author tanabe
 */
public class ArraySumProcess implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    Message in = exchange.getIn();
    ArrayList<Integer> list = in.getBody(ArrayList.class);

    Integer sum = list.stream().reduce(0, (l, r) -> l + r);

    in.setHeader("result", sum);
  }

}
