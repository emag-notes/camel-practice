# web-scraping

* 起動時に1回限り取ってくる
* `https://www.google.co.jp` にアクセス
* タイトルの内容を取って"title_data"に保存
* 保存されたtitle_dataを標準出力
* httpコンポーネントは動的にURLを変更してアクセスしている

## 事前条件

* JDK 8

## 実行方法

``` sh
$ ./gradlew run
[...]
Google
```

## 参考

http://qiita.com/daikuro/items/6952b13587c2d7fc235e
