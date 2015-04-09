# httpget

`http://www.yahoo.co.jp` にアクセス

## 事前条件

* JDK 8

## 実行方法

``` sh
$ ./gradlew run
[...]
10 [main] INFO org.apache.camel.main.MainSupport - Apache Camel 2.15.1 starting
196 [main] INFO org.apache.camel.impl.DefaultCamelContext - Apache Camel 2.15.1 (CamelContext: camel-1) is starting
197 [main] INFO org.apache.camel.management.ManagedManagementStrategy - JMX is enabled
321 [main] INFO org.apache.camel.impl.converter.DefaultTypeConverter - Loaded 191 type converters
460 [main] INFO org.apache.camel.component.http4.HttpComponent - Created ClientConnectionManager org.apache.http.impl.conn.PoolingHttpClientConnectionManager@6ab7a896
488 [main] INFO org.apache.camel.impl.DefaultCamelContext - AllowUseOriginalMessage is enabled. If access to the original message is not needed, then its recommended to turn this option off as it may improve performance.
488 [main] INFO org.apache.camel.impl.DefaultCamelContext - StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
531 [main] INFO org.apache.camel.impl.DefaultCamelContext - Route: route1 started and consuming from: Endpoint[timer://httpget?repeatCount=1]
532 [main] INFO org.apache.camel.impl.DefaultCamelContext - Total 1 routes, of which 1 is started.
534 [main] INFO org.apache.camel.impl.DefaultCamelContext - Apache Camel 2.15.1 (CamelContext: camel-1) started in 0.336 seconds
1624 [Camel (camel-1) thread #0 - timer://httpget] INFO end - Exchange[ExchangePattern: InOnly, BodyType: org.apache.camel.converter.stream.CachedOutputStream.WrappedInputStream, Body: [Body is instance of java.io.InputStream]]
```

## 参考

http://sourceforge.jp//projects/cameluserjp/wiki/初めてのCamel2
