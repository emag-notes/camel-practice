package camel.calcapi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.processor.StopProcessor;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * @author tanabe
 */
public class CalcAddRouteTest extends CamelTestSupport {

  @Override
  protected RouteBuilder[] createRouteBuilders() throws Exception {
    return new RouteBuilder[]{new CalcAddRoute()};
  }

  @Test
  public void three_numbers() throws Exception {
    Exchange exchange = createExchangeWithBody("");
    exchange.getIn().setHeader("q", "1,2,3");
    template.send(CalcAddRoute.IN, exchange);
    throwIfError(exchange);

    assertThat(exchange.getIn().getBody(String.class), is("{\"result\":6}"));
  }

  @Test
  public void without_comma() throws Exception {
    Exchange exchange = createExchangeWithBody("");
    exchange.getIn().setHeader("q", "1");
    template.send(CalcAddRoute.IN, exchange);
    throwIfError(exchange);

    assertThat(exchange.getIn().getBody(String.class), is("{\"result\":1}"));
  }

  @Test
  public void use_mock() throws Exception {
    // 指定ルートの to("") のメソッド全てに Mock を仕込む
    setMock(CalcAddRoute.CLASSNAME);

    // log:result のモックを取得
    MockEndpoint mock = getMockEndpoint("mock:log:result");

    // モックの期待値を設定(メッセージが 1 件流れてくること)
    mock.expectedMessageCount(1);
    // モックの期待値を設定(result ヘッダに 1 がセットされていること)
    mock.expectedHeaderReceived("result", 1);

    // log:result 以降のルートにはデータを流さない
    mock.setReporter(new Processor() {
      @Override
      public void process(Exchange exchange) throws Exception {
        new StopProcessor().process(exchange);
      }
    });
    // mock.setReporter(new StopProcessor()); こちらと等価

    // 試験データをルートに流す
    Exchange exchange = createExchangeWithBody("");
    exchange.getIn().setHeader("q", "1");
    template.send(CalcAddRoute.IN, exchange);
    throwIfError(exchange);

    // モックが期待値通りになっているか確認
    assertMockEndpointsSatisfied();
  }

  private void throwIfError(Exchange exchange) throws Exception {
    if (exchange.getException() != null) {
      throw exchange.getException();
    }
  }

  public void setMock(String routeId) throws Exception {
    final String pattern = "*";

    context.getRouteDefinition(routeId)
      // すべてのポイントで割り込み
      .adviceWith(context, new AdviceWithRouteBuilder() {
        @Override
        public void configure() throws Exception {
          mockEndpoints(pattern);
        }
      });

  }
}