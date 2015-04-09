package camel.filetofile;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author tanabe
 *
 * inbox にあるファイルを取得し、outbox に出力する
 * 処理後、 inbox のファイルは削除しない
 *
 */
public class FileToFileRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("file:inbox?noop=true&delay=5000") // noop=true:処理後にファイルの削除をしない
//    from("file:inbox") // noop=false(デフォルト):処理後にファイルの削除をする。ファイルは .camel に退避
      .to("file:outbox?fileName=${file:onlyname.noext}.${date:now:yyyyMMdd-HH.mm.ss}");
  }

}
