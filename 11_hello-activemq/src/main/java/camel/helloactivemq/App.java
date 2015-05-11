package camel.helloactivemq;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

/**
 * @author tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();

    try {
      context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));

      context.addRoutes(new RouteBuilder() {

        @Override
        public void configure() throws Exception {
          from("activemq:queue:test.queue")
            .to("stream:out");
        }

      });

      context.start();

      ProducerTemplate template = context.createProducerTemplate();
      template.sendBody("activemq:test.queue", "Hello to ActiveMQ!");

      TimeUnit.SECONDS.sleep(2);
    } finally {
      context.stop();
    }
  }

}
