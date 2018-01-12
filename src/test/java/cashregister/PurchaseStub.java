package cashregister;

/**
 * Created by liyue on 2018/1/12
 */
public class PurchaseStub extends Purchase {
  public PurchaseStub(Item[] items) {
    super(items);
  }

  @Override
  public String asString() {
    return "this is a test.";
  }
}
