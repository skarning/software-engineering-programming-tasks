public class NumberPrinter {
    private int from;
    private int to;

    public NumberPrinter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getNumber(int inputNumber) {
        if (inputNumber == 0)
            return 0;
        if (inputNumber == 1)
            return 1;
        if (inputNumber == 2)
            return 2;
        return 0;
    }
}
