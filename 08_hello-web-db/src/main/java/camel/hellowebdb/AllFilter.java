package camel.hellowebdb;

import org.apache.camel.Exchange;
import org.apache.camel.spi.HeaderFilterStrategy;

/**
 * HTTP レスポンスヘッダをフィルタリング
 * @author tanabe
 */
public class AllFilter implements HeaderFilterStrategy {

  // レスポンスフィルタ
  @Override
  public boolean applyFilterToCamelHeaders(String headerName, Object headerValue, Exchange exchange) {
    return true;
  }

  // リクエスト受信フィルタ
  @Override
  public boolean applyFilterToExternalHeaders(String headerName, Object headerValue, Exchange exchange) {
    return false;
  }

}
