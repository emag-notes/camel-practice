package camel.hellowebdb;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 * @author tanabe
 */
@Component
public class HelloRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    // エラー処理
    onException(Exception.class)
      .handled(true) // こちらでうまいこと処理したよフラグ
      .to("log:error")
      .setHeader(Exchange.HTTP_RESPONSE_CODE).constant(500);

    // Tomcat にアクセスがあった場合
    from("servlet:///list")
      .to("log:in")
      .to("sql:SELECT * FROM myitems WHERE user_id = :#id")
      .marshal().json(JsonLibrary.Gson)
      // removeHeaders で HTTP ヘッダで余計な情報を返さないこともできる
//      .removeHeaders("*") これでもいいが、全部のルートにつけないといけないので、別途フィルタ(AllFilter)を書く
      .to("log:out");
  }

}
