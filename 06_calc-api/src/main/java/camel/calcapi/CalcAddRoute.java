package camel.calcapi;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 * カンマ区切りのデータを足して、結果を json で返す
 * @author tanabe
 */
public class CalcAddRoute extends RouteBuilder {

  public static final String CLASSNAME = CalcAddRoute.class.getSimpleName();

  public static final String IN = "direct:in" + CLASSNAME;

  @Override
  public void configure() throws Exception {
    from(IN).routeId(CLASSNAME)
      .to("log:in" + CLASSNAME)
      .process(new CsvToArrayProcess())
      .process(new ArraySumProcess())
      .to("log:result")
      .process(new ResponseProcess())
      .marshal().json(JsonLibrary.Gson)
      .to("log:out" + CLASSNAME);
  }
}
