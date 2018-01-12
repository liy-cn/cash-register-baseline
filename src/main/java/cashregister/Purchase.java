package cashregister;

public class Purchase {

    private Item[] items;

    private boolean callFlag = false;

    public Purchase(Item[] items) {

        this.items = items;
    }

    public String asString() {
        String out = "";

        for (Item item : items) {
            out += item.getName() + "\t" + item.getPrice() + "\n";
        }

        return out;
    }

    public boolean isCallFlag() {
        return callFlag;
    }

    public void setCallFlag(boolean callFlag) {
        this.callFlag = callFlag;
    }
}
