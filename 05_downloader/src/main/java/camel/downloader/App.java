package camel.downloader;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;

/**
 * @author tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.err.println("destination is required");
      System.exit(1);
    }

    for (int i = 0; i < 100; i++) {
      download("test" + i + ".bm;", args[0]);
    }

  }

  private static void download(String fileName, String destDir) throws Exception {
    CamelContext context = new DefaultCamelContext();
    context.start();

    ProducerTemplate producer = context.createProducerTemplate();
    // ダウンロード
    String uri = "http4://localhost/test/" + fileName;
    Exchange exchange = new DefaultExchange(context);
    exchange = producer.send(uri, exchange);
    // ダウンロードしたデータの保存ファイル名を決める
    exchange.setIn(exchange.getOut());
    exchange.getIn().setHeader(Exchange.FILE_NAME, fileName);
    // ローカルに保存
    uri = "file://" + destDir;
    producer.send(uri, exchange);
  }

}
