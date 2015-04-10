package camel.calcapi;

import org.apache.camel.main.Main;

/**
 * @author tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Main camel = new Main();
    camel.addRouteBuilder(new HttpRoute());
    camel.addRouteBuilder(new CalcAddRoute());
    camel.run();
  }

}
