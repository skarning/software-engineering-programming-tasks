import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class NumberPrinterTests {
    private final static int TEST_FROM = 1;
    private final static int TEST_TO = 100;

    private final static int NUM_DIVIDABLE_WITH_THREE = 3;
    private final static int NUM_DIVIDABLE_WITH_FIVE = 5;
    private final static int NUM_DIVIDABLE_WITH_THREE_AND_FIVE = 15;


    /*
        Checks if method returns
        correct value for each input from
        TEST_FROM to TEST_TO
    */
    @Test
    public void getCorrectStringFromInput_correct() {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM, TEST_TO);
        for(int i = TEST_FROM; i <= TEST_TO; i++) {
            if ((i % 3) == 0 && (i % 5) == 0)
                assertEquals("HiOf", numberPrinter.getCorrectStringFromInputValue(i));
            else if ((i % 3) == 0)
                assertEquals("Hi", numberPrinter.getCorrectStringFromInputValue(i));
            else if ((i % 5) == 0)
                assertEquals("Of", numberPrinter.getCorrectStringFromInputValue(i));

            else
                assertEquals("" + i, numberPrinter.getCorrectStringFromInputValue(i));
        }
    }

    /*
        Checks if a number dividable
        with three returns correct output
    */
    @Test
    public void getCorrectStringFromInput_Hi_three() {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM, TEST_TO);
        assertEquals("Hi", numberPrinter.getCorrectStringFromInputValue(NUM_DIVIDABLE_WITH_THREE));
    }

    /*
        Checks if a number dividable
        with five returns correct output
    */
    @Test
    public void getCorrectStringFromInput_Of_five() {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("Of", numberPrinter.getCorrectStringFromInputValue(NUM_DIVIDABLE_WITH_FIVE));
    }

    /*
        Checks if a number dividable
        with three and five returns correct output
    */
    @Test
    public void getCorrectStringFromInput_HiOf_three_and_five() {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("HiOf", numberPrinter.getCorrectStringFromInputValue(NUM_DIVIDABLE_WITH_THREE_AND_FIVE));
    }

    /*
        Loops through every number from TEST_FROM to TEST_To
        dividable with three and checks if output is correct
    */
    @ParameterizedTest()
    @MethodSource ("numbersDividableWithThree")
    public void getCorrectStringFromInput_Hi_number_is_dividable_with_three(int number) {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("Hi", numberPrinter.getCorrectStringFromInputValue(number));
    }

    /*
        Loops through every number from TEST_FROM to TEST_To
        dividable with five and checks if output is correct
    */
    @ParameterizedTest
    @MethodSource ("numbersDividableWithFive")
    public void getCorrectStringFromInput_Of_number_is_dividable_with_five(int number) {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("Of", numberPrinter.getCorrectStringFromInputValue(number));
    }

    /*
        Loops through every number from TEST_FROM to TEST_To
        dividable with three and five and checks if output is correct
    */
    @ParameterizedTest
    @MethodSource ("numbersDividableWithThreeAndFive")
    public void getCorrectStringFromInput_HiOf_number_is_dividable_with_three_and_five(int number) {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("HiOf", numberPrinter.getCorrectStringFromInputValue(number));
    }

    /*
        Returns a stream of numbers
        dividable with three but not five
     */
    public static Stream numbersDividableWithThree() {
        List<Integer> testRange = IntStream.rangeClosed(TEST_FROM, TEST_TO).boxed().collect(Collectors.toList());
        return testRange.stream().filter(s->s % 3 == 0 && s % 5 != 0);
    }

    /*
        Returns a stream of numbers
        dividable with five but not three
    */
    public static Stream numbersDividableWithFive() {
        List<Integer> testRange = IntStream.rangeClosed(TEST_FROM, TEST_TO).boxed().collect(Collectors.toList());
        return testRange.stream().filter(s->s % 5 == 0 && s % 3 != 0);
    }

    /*
        Returns a stream of numbers
        dividable with three and five
    */
    public static Stream numbersDividableWithThreeAndFive() {
        List<Integer> testRange = IntStream.rangeClosed(TEST_FROM, TEST_TO).boxed().collect(Collectors.toList());
        return testRange.stream().filter(s->s % 3 == 0 && s % 5 == 0);
    }

    /*
        Checks if numbers in a
        subset of the input numbers
        is correct
    */
    @ParameterizedTest
    @ValueSource (ints = {3,6,9,12})
    public void getCorrectStringFromInput_Hi_number_is_dividable_with_three_subset(int number) {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("Hi", numberPrinter.getCorrectStringFromInputValue(number));
    }

    /*
        Checks if numbers in a
        subset of the input numbers
        is correct
    */
    @ParameterizedTest
    @ValueSource (ints = {5,10,20})
    public void getCorrectStringFromInput_Of_number_is_dividable_with_five_subset(int number) {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("Of", numberPrinter.getCorrectStringFromInputValue(number));
    }

    /*
        Checks if numbers in a
        subset of the input numbers
        is correct
    */
    @ParameterizedTest
    @ValueSource (ints = {15, 30, 45, 60})
    public void getCorrectStringFromInput_HiOf_number_is_dividable_with_three_and_five_subset(int number) {
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM,TEST_TO);
        assertEquals("HiOf", numberPrinter.getCorrectStringFromInputValue(number));
    }

    /*
        Checks if TooNegativeException
        is thrown for negative numbers
    */
    @ParameterizedTest
    @ValueSource (ints = {0,-1,-3,-5,-7,-11})
    public void getCorrectStringFromInput_TooNegativeException_zero_and_negative_numbers(int number){
        NumberPrinter numberPrinter = new NumberPrinter(TEST_FROM, TEST_TO);
        assertThrows(TooNegativeException.class, () -> {
            numberPrinter.getCorrectStringFromInputValue(number);
        });
    }
}
