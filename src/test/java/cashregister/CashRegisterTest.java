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
        Purchase purchase = new PurchaseStub(null);
        cashRegister.process(purchase);

        Assert.assertEquals(true, printer.verifyCall());
        //verify that printer was called
    }

    @Test
    public void should_print_purchased_items() {
        //initialize CashRegister and fake Printer
        PrinterMock printer = new PrinterMock();
        CashRegister cashRegister = new CashRegister(printer);
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < 10; i++) {
            Item item = new Item("item"+i, i);
            list.add(item);
        }
        Item[] items = list.toArray(new Item[list.size()]);
        Purchase purchase = new Purchase(items);
        cashRegister.process(purchase);

        Assert.assertEquals(true, printer.verifyCall());
        //verify that printer was called
    }

    @Test
    public void verify_purchase_stub() {
        //initialize CashRegister and fake Printer
        PrinterMock printer = new PrinterMock();
        CashRegister cashRegister = new CashRegister(printer);
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < 10; i++) {
            Item item = new Item("item"+i, i);
            list.add(item);
        }
        Item[] items = list.toArray(new Item[list.size()]);
        Purchase purchase = new PurchaseStub(items);
        cashRegister.process(purchase);

        Assert.assertEquals("this is a test.",purchase.asString());

        //verify that printer was called
    }
}