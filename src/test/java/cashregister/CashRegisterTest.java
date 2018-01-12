package cashregister;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CashRegisterTest {


    @Test
    public void should_print_null_purchase() {
        //initialize CashRegister and fake Printer
        Printer printer = new Printer();
        CashRegister cashRegister = new CashRegister(printer);
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < 10; i++) {
            Item item = new Item("item"+i, i);
            list.add(item);
        }
        Item[] items = list.toArray(new Item[list.size()]);
        Purchase purchase = new Purchase(items);
        cashRegister.process(purchase);

        Assert.assertEquals(true, printer.isCallFlag());

        //verify that printer was called
    }
}