package camel.tenminutescamel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 */
public class HelloRoute6 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    // onException は例外処理用の特別なルート
    // 通常ルートより前に書く必要がある
    onException(Exception.class)
      .maximumRedeliveries(10) // 最大 10 回のリトライ
      .delayPattern("0:1000;5:3000") // 初回から 4 回までのリトライ間隔 1 秒, 5 回目以降は 3 秒
      .handled(true) // 正常に処理した、例外を再スローしない、トランザクションをコミットした、といったような意味
      .setBody().constant("Something wrong...")
      .to("stream:out");

    from("stream:in?promptMessage=Enter : ").routeId(HelloRoute6.class.getName())
      .process(new HelloProcessor2())
      .to("stream:out");
  }

}
