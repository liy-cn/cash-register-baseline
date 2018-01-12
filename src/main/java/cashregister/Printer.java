package cashregister;

class Printer {

    private boolean callFlag = false;

    public void print(String printThis) {
        System.out.println("Printer: \n" + printThis);
        //throw new UnsupportedOperationException("Not Implemented");
        this.callFlag = true;
    }

    public boolean isCallFlag() {
        return callFlag;
    }
}
