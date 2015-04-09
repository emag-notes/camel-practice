package camel.httpget;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

/**
 * @author tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Main camel = new Main();
    camel.addRouteBuilder(route);
    camel.run();
  }

  static RouteBuilder route = new RouteBuilder() {

    @Override
    public void configure() throws Exception {
      from("timer:httpget?repeatCount=1") // 1 回だけ実行
        .to("http4://www.yahoo.co.jp")
//        .to("http4://www.yahoo.co.jp?proxyAuthHost=proxy-host-name&proxyAuthPort=proxy-port-num")
        .to("log:end");
    }

  };

}
