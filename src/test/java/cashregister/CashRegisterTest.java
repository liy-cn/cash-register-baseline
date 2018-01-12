package cashregister;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CashRegisterTest {


  @Test
  public void should_print_null_purchase() {
    //initialize CashRegister and fake Printer
    PrinterMock printer = new PrinterMock();
    CashRegister cashRegister = new CashRegister(printer);
    Item[] items = new Item[]{};
    Purchase purchase = new Purchase(items);
    cashRegister.process(purchase);

    Assert.assertEquals(1, printer.getInvokeCounter());
    //verify that printer was called
  }

  @Test
  public void should_print_purchased_items() {
    //initialize CashRegister and fake Printer
    PrinterMock printer = new PrinterMock();
    CashRegister cashRegister = new CashRegister(printer);
    List<Item> list = new ArrayList<Item>();
    String out = "";
    for (int i = 0; i < 10; i++) {
      Item item = new Item("item" + i, i);
      list.add(item);
      out += item.getName() + "\t" + item.getPrice() + "\n";
    }

    Item[] items = list.toArray(new Item[list.size()]);
    Purchase purchase = new Purchase(items);
    cashRegister.process(purchase);

    Assert.assertEquals(out,printer.getPrintMessage());
    //verify that printMessage is equal to items string.
  }

  @Test
  public void verify_purchase_stub() {
    //initialize CashRegister and fake Printer
    PrinterMock printer = new PrinterMock();
    CashRegister cashRegister = new CashRegister(printer);
    List<Item> list = new ArrayList<Item>();
    for (int i = 0; i < 10; i++) {
      Item item = new Item("item" + i, i);
      list.add(item);
    }
    Item[] items = list.toArray(new Item[list.size()]);
    Purchase purchase = new PurchaseStub(items);
    cashRegister.process(purchase);

    Assert.assertEquals("this is a test.", printer.getPrintMessage());

    //verify the PurchaseStub
  }


  @Test
  public void should_invoke_counter_is_same_with_print_counter() {
    //initialize CashRegister and fake Printer
    PrinterMock printer = new PrinterMock();
    CashRegister cashRegister = new CashRegister(printer);
    List<Item> list = new ArrayList<Item>();
    for (int i = 0; i < 10; i++) {
      Item item = new Item("item" + i, i);
      list.add(item);
    }
    Item[] items = list.toArray(new Item[list.size()]);
    Purchase purchase = new Purchase(items);
    cashRegister.process(purchase);
    cashRegister.process(purchase);
    cashRegister.process(purchase);

    Assert.assertEquals(3, printer.getInvokeCounter());

    //verify that printer's counter is the same with process invoked times.
  }

}