public class NumberPrinter {
    private int from;
    private int to;

    public NumberPrinter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public String getNumber(int inputNumber) {
        if ((inputNumber % 3) == 0)
            return "HI";
        return "" + inputNumber;
    }
}
