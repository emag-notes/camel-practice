package camel.hellowebdb;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author tanabe
 */
public class HelloRouteTest extends CamelSpringTestSupport {

  @Override
  protected AbstractApplicationContext createApplicationContext() {
    return new ClassPathXmlApplicationContext("spring.xml");
  }

  @Test
  public void should_log_once_in_every_3_second() throws Exception {
    TimeUnit.SECONDS.sleep(3);
  }

}