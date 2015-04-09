package camel.filetofile;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

/**
 * @author tanabe
 */
public class Main {

  public static void main(String[] args) throws Exception {
    // 最初に CamelContext を作成する
    CamelContext context = new DefaultCamelContext();
    RouteBuilder builder = new FileToFileRoute();
    context.addRoutes(builder);

    // 作成した CamelContext を開始し、60 秒後に停止
    context.start();
    TimeUnit.SECONDS.sleep(60);
    context.stop();
  }

}
