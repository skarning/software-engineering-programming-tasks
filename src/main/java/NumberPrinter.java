public class NumberPrinter {
    private int from;
    private int to;

    public NumberPrinter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public String getNumber(int inputNumber) {
        if (((inputNumber % 3) == 0) && (inputNumber % 5) == 0)
            return "HiOf";
        if ((inputNumber % 3) == 0)
            return "Hi";
        if ((inputNumber % 5) == 0)
            return "Of";
        return "" + inputNumber;
    }

    public void printNumbers() {
        for(int i = from; i <= to; i++) {
            System.out.println(getNumber(i));
        }
    }
}
