# svn-update

引数で指定したディレクトリに対して、3 分ごとに `svn update` を実施する

## 事前条件

* JDK 8

## 実行方法

``` sh
$ ./gradlew run -Pargs="/path/to/svn-repo"
```

## 参考

http://sourceforge.jp/projects/cameluserjp/wiki/定期的にsubversionのupdateを実行
