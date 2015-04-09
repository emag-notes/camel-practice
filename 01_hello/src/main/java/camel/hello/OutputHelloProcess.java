package camel.hello;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author tanabe
 */
// .process(xxx)の場合は「Processorの実装プラス」を呼び出すことができる
public class OutputHelloProcess implements Processor {

  // .process(xxx)が実行されると、この process メソッドが呼び出される
  @Override
  public void process(Exchange exchange) throws Exception {
    System.out.println("Hello, Camel!");
  }

}
