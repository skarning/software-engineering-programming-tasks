public class NumberPrinter {
    private int from;
    private int to;

    public NumberPrinter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    /*
        If paramater is dividable with:
        5 and 3 it returns HiOF
        3 it returns Hi
        5 it returns Of
     */
    public String getCorrectStringFromInputValue(int inputNumber) {
        if (((inputNumber % 3) == 0) && (inputNumber % 5) == 0)     // Checks if number is dividable with both 3 and 5
            return "HiOf";
        if ((inputNumber % 3) == 0)                                 // Checks if number is dividable with 3
            return "Hi";
        if ((inputNumber % 5) == 0)                                 // Checks if number is dividable with 5
            return "Of";
        return "" + inputNumber;
    }

    public void printNumbers() {
        for(int i = from; i <= to; i++)
            System.out.println(getCorrectStringFromInputValue(i));
    }
}
