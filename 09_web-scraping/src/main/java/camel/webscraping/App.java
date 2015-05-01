package camel.webscraping;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.main.Main;

import java.net.URL;

/**
 * @author tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    // camel の設定と起動
    Main camel = new Main();
    camel.addRouteBuilder(getTitleRoute);
    camel.start();

    // camel のルートに送るデータを作成
    Exchange exchange = new DefaultExchange(new DefaultCamelContext());
    exchange.getIn().setHeader(Exchange.HTTP_URI, "https://www.google.co.jp");

    // camel のルートにデータを送る
    camel.getCamelTemplate().send("direct:start", exchange);

    // 結果を取得・表示
    String title = exchange.getIn().getHeader("title_data", String.class);
    System.out.println(title);
  }

  /**
   * HTTP(S) アクセスしてタイトルを取ってくるシナリオ
   */
  static RouteBuilder getTitleRoute = new RouteBuilder() {

    @Override
    public void configure() throws Exception {
      String dummyURL = "http://dummy";

      String httpProxy = System.getenv("http_proxy");
      if (httpProxy != null) {
        URL httpProxyUrl = new URL(httpProxy);
        dummyURL = dummyURL + "?proxyHost=" + httpProxyUrl.getHost() + "&proxyPort=" + httpProxyUrl.getPort();
      }

      from("direct:start")
        .to(dummyURL)
        .unmarshal().tidyMarkup() // HTML -> XML に変換
        .setHeader("title_data")
        .xpath("//title/text()");
    }

  };

}
