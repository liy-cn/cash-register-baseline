package cashregister;

/**
 * Created by liyue on 2018/1/12
 */
public class PrinterMock extends Printer {
  private int invokeCounter = 0;
  private String printMessage;

  @Override
  public void print(String printThis) {
    this.printMessage = printThis;
    System.out.println("Printer: \n" + printThis);
    invokeCounter ++;
  }

  public int getInvokeCounter() {
    return invokeCounter;
  }

  public String getPrintMessage(){
    return this.printMessage;
  }

}
