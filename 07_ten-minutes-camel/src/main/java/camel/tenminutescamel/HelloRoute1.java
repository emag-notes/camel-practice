package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * ルート=ベルトコンベア
 * @author tanabe
 */
public class HelloRoute1 extends RouteBuilder {

  // configure()の中に複数のルートを作れる
  @Override
  public void configure() throws Exception {
    from("timer:test-hello") // ルート毎に先頭に from() を書く
      .to("log:test-log"); // 先頭以外は from() 以外になる
  }

}
