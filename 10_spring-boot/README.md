# spring-boot

月曜から金曜の 10 - 18 時の間、1 秒ごとに現在時刻を標準出力に出す

## 事前条件

* JDK 8

## 実行方法

``` sh
./gradlew bootRun
```

or

``` sh
./gradlew clean build && java -jar build/libs/spring-boot.jar
```

以下のように 1 秒毎に現在時刻が標準出力に出力される。

``` sh
2015-05-11T11:28:16.001
2015-05-11T11:28:17.001
2015-05-11T11:28:18.001
2015-05-11T11:28:19.001
```

## 参考

* http://qiita.com/daikuro/items/d361f54564e8a59bf631
* https://cwiki.apache.org/confluence/display/CAMEL/Spring+Boot