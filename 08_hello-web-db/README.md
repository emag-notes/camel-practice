# hello-web-db

Tomcat と PostgreSQL を利用した Camel のサンプル。

myitems テーブルの SELECT の結果を json で返すような API。

## 事前条件

* JDK 8
* Tomcat 8
* Docker
 * 自前で PostgreSQL を用意する場合は不要です。手順を適宜読み替えてください。

## 実行方法

### PostgreSQL の準備

以降、Docker で PostgreSQL を用意します。

#### PostgreSQL の Docker コンテナを起動

``` sh
 docker run -d --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
```

#### データ作成

``` sh
docker run -it --link postgres:postgres --rm postgres sh -c 'exec psql -h "$POSTGRES_PORT_5432_TCP_ADDR" -p "$POSTGRES_PORT_5432_TCP_PORT" -U postgres'
```

psql にプロンプトが移ったら、以下の DDL/DML を発行する。面倒なので postgres データベースを使います。。

``` sql
DROP TABLE IF EXISTS myitems;

CREATE TABLE myitems (
  user_id varchar(255) NOT NULL,
  user_name varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO myitems (user_id, user_name) VALUES ('00001', 'user01');
INSERT INTO myitems (user_id, user_name) VALUES ('00002', 'user02');
```

### ビルド & デプロイ

``` sh
$ ./gradlew clean war
```

build/libs/hello-web-db.war を Tomcat 8 にデプロイ。

### 実行

``` sh
$ curl "localhost:8080/hello-web-db/test/list?id=00001"
[{"user_id":"00001","user_name":"user01"}]
```

## 参考

* http://qiita.com/daikuro/items/bccbd5ff0308ccb2ac8e
* https://github.com/d7kuro/HelloMySQL