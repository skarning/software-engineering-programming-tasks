import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberPrinterTests {

    @Test
    public void getListOfNumbersTest() {
        NumberPrinter numberPrinter = new NumberPrinter(0, 100);
        assertEquals(0, numberPrinter.getListOfNumbers());
    }
}
