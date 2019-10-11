import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberPrinterTests {

    @Test
    public void getNumbersTest() {
        NumberPrinter numberPrinter = new NumberPrinter(0, 100);
        assertEquals("HI", numberPrinter.getNumber(0));
        assertEquals("1", numberPrinter.getNumber(1));
        assertEquals("2", numberPrinter.getNumber(2));
        assertEquals("HI", numberPrinter.getNumber(3));
    }
}
