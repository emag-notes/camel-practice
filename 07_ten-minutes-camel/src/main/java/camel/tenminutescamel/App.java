package camel.tenminutescamel;

import org.apache.camel.main.Main;

/**
 * @author tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    System.out.println("Hello, Camel");

    Main camel = new Main();
    camel.addRouteBuilder(new HelloRoute7());
    camel.addRouteBuilder(new HelloRoute8());
    camel.run(); // Main#start() は 1 度だけ起動。run はデーモン
  }

}
