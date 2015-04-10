package camel.calcapi;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * カンマ区切りの HTTP クエリパラメータ q のを配列に変換
 * @author tanabe
 */
public class CsvToArrayProcess implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    Message in = exchange.getIn();
    String q = in.getHeader("q", String.class);

    List<Integer> numbers =
      Arrays.asList(q.split(",")).stream()
        .map(s -> {
          int i;
          try {
            i = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            throw new RuntimeException("Please input numbers", e);
          }
          return i;
        })
        .collect(Collectors.toList());

    in.setBody(numbers);
  }
}
