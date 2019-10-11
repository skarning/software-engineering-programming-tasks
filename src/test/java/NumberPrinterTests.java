import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberPrinterTests {

    @Test
    public void getNumbersTest() {
        NumberPrinter numberPrinter = new NumberPrinter(0, 100);
        for(int i = 0; i <= 100; i++) {
            if ((i % 3) == 0 && (i % 5) == 0)
                assertEquals("HiOf", numberPrinter.getNumber(i));
            else if ((i % 3) == 0)
                assertEquals("Hi", numberPrinter.getNumber(i));
            else if ((i % 5) == 0)
                assertEquals("Of", numberPrinter.getNumber(i));

            else
                assertEquals("" + i, numberPrinter.getNumber(i));
        }
    }
}
