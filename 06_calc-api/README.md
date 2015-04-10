# calc-api

CSV 形式で送った数字の合計を返す API

## 事前条件

* JDK 8

## 実行方法

### API サーバの起動

``` sh
$ ./gradlew run
[...]
9 [main] INFO org.apache.camel.main.MainSupport - Apache Camel 2.15.1 starting
211 [main] INFO org.apache.camel.impl.DefaultCamelContext - Apache Camel 2.15.1 (CamelContext: camel-1) is starting
212 [main] INFO org.apache.camel.management.ManagedManagementStrategy - JMX is enabled
337 [main] INFO org.apache.camel.impl.converter.DefaultTypeConverter - Loaded 192 type converters
435 [main] INFO org.apache.camel.impl.DefaultCamelContext - AllowUseOriginalMessage is enabled. If access to the original message is not needed, then its recommended to turn this option off as it may improve performance.
435 [main] INFO org.apache.camel.impl.DefaultCamelContext - StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
508 [main] INFO org.apache.camel.component.jetty.JettyHttpComponent - Using default Jetty continuation timeout for: Endpoint[http://0.0.0.0:5555/]
514 [main] INFO org.eclipse.jetty.server.Server - jetty-8.1.16.v20140903
535 [main] INFO org.eclipse.jetty.server.AbstractConnector - Started SelectChannelConnector@0.0.0.0:5555
543 [main] INFO org.apache.camel.impl.DefaultCamelContext - Route: route1 started and consuming from: Endpoint[http://0.0.0.0:5555/]
544 [main] INFO org.apache.camel.impl.DefaultCamelContext - Route: CalcAddRoute started and consuming from: Endpoint[direct://inCalcAddRoute]
544 [main] INFO org.apache.camel.impl.DefaultCamelContext - Total 2 routes, of which 2 is started.
546 [main] INFO org.apache.camel.impl.DefaultCamelContext - Apache Camel 2.15.1 (CamelContext: camel-1) started in 0.333 seconds
```

### API へのアクセス

``` sh
$ curl "localhost:5555?q=1,2,3"
{"result":6}%
```

## 参考

http://qiita.com/daikuro/items/2b9e495ae61a612f1375
