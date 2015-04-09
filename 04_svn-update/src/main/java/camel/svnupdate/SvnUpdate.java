package camel.svnupdate;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

/**
 * @author tanabe
 */
public class SvnUpdate {

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.err.println("Please select svn directory");
      System.exit(1);
    }
    String dir = args[0];

    Main camel = new Main();

    camel.addRouteBuilder(new RouteBuilder() {

      int time = 1000 * 60 * 3; // 3 分ごと

      String timer = "timer:trigger?period=" + time;
      String exec = "exec://svn?args=update&workingDir=" + dir;

      @Override
      public void configure() throws Exception {
        from(timer).to(exec);
      }

    });

    camel.run();
  }

}
