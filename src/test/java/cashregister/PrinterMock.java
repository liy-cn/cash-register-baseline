package cashregister;

/**
 * Created by liyue on 2018/1/12
 */
public class PrinterMock extends Printer{
  private boolean callFlag = false;

  @Override
  public void print(String printThis) {
    System.out.println("Printer: \n" + printThis);
    this.callFlag = true;
  }

  public boolean verifyCall() {
    return callFlag;
  }

}
