package camel.hello;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

/**
 * @author tanabe
 */
public class HelloCamel {

  public static void main(String[] args) throws Exception {
    // Camel 本体
    Main main = new Main();

    // Camel に「ルート」を登録
    main.addRouteBuilder(new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from("timer:timerName?period=3000")
          .process(new OutputHelloProcess());
      }
    });

    // Camel の起動
    main.run();
  }
}
