package camel.calcapi;

import org.apache.camel.Exchange;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

/**
 * @author tanabe
 */
public class CsvToArrayProcessTest extends CamelTestSupport {

  @Test
  public void should_convert_csv_into_array() throws Exception {
    Exchange exchange = createExchangeWithBody("");
    exchange.getIn().setHeader("q", "1,2,3");
    CsvToArrayProcess sut = new CsvToArrayProcess();
    sut.process(exchange);

    List<Integer> list = exchange.getIn().getBody(List.class);

    assertThat(list.size(), is(3));
    assertThat(list.get(0), is(1));
    assertThat(list.get(1), is(2));
    assertThat(list.get(2), is(3));
  }

  @Test
  public void should_be_ignored_without_comma() throws Exception {
    Exchange exchange = createExchangeWithBody("");
    exchange.getIn().setHeader("q", "3");
    CsvToArrayProcess sut = new CsvToArrayProcess();
    sut.process(exchange);

    List<Integer> list = exchange.getIn().getBody(List.class);

    assertThat(list.size(), is(1));
    assertThat(list.get(0), is(3));
  }

  @Test(expected = Exception.class)
  public void should_error_including_non_number() throws Exception {
    Exchange exchange = createExchangeWithBody("");
    exchange.getIn().setHeader("q", "1,2,AA");
    CsvToArrayProcess sut = new CsvToArrayProcess();
    sut.process(exchange);

    exchange.getIn().getBody(List.class);
  }
}