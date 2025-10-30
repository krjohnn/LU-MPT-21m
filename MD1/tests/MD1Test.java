import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the MD1 class.
 */
class MD1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final String lineSeparator = System.lineSeparator();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private String generateExpectedPyramid(int Z, int N) {
        StringBuilder expected = new StringBuilder();
        expected.append("1234567890123456789012345678901234567890123456789012345678901234567890").append(lineSeparator);
        for (int i = 0; i < Z; i++) {
            expected.append(" ".repeat(N + i));
            for (int k = 0; k < Z - i; k++) {
                expected.append("+ ");
            }
            expected.append(lineSeparator);
        }
        return expected.toString();
    }

    @Nested
    @DisplayName("Valid Input Tests")
    class ValidInputTests {

        @Test
        @DisplayName("Standard valid input (Z=3, N=5)")
        void standardValidInput() {
            String[] args = {"3", "5"};
            MD1.main(args);
            String expectedOutput = generateExpectedPyramid(3, 5);
            assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        @DisplayName("Lower boundary valid input (Z=1, N=1)")
        void lowerBoundaryValidInput() {
            String[] args = {"1", "1"};
            MD1.main(args);
            String expectedOutput = generateExpectedPyramid(1, 1);
            assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        @DisplayName("Upper boundary valid input (Z=19, N=29)")
        void upperBoundaryValidInput() {
            String[] args = {"19", "29"};
            MD1.main(args);
            String expectedOutput = generateExpectedPyramid(19, 29);
            assertEquals(expectedOutput, outContent.toString());
        }
    }

    @Nested
    @DisplayName("Invalid Input Tests")
    class InvalidInputTests {

        @Test
        @DisplayName("Invalid Z (too low)")
        void invalidZTooLow() {
            String[] args = {"0", "10"};
            MD1.main(args);
            String expectedError = "DATI NAV KOREKTI!" + lineSeparator;
            assertEquals(expectedError, outContent.toString());
        }

        @Test
        @DisplayName("Invalid Z (too high)")
        void invalidZTooHigh() {
            String[] args = {"20", "10"};
            MD1.main(args);
            String expectedError = "DATI NAV KOREKTI!" + lineSeparator;
            assertEquals(expectedError, outContent.toString());
        }

        @Test
        @DisplayName("Invalid N (too low)")
        void invalidNTooLow() {
            String[] args = {"10", "0"};
            MD1.main(args);
            String expectedError = "DATI NAV KOREKTI!" + lineSeparator;
            assertEquals(expectedError, outContent.toString());
        }

        @Test
        @DisplayName("Invalid N (too high)")
        void invalidNTooHigh() {
            String[] args = {"10", "30"};
            MD1.main(args);
            String expectedError = "DATI NAV KOREKTI!" + lineSeparator;
            assertEquals(expectedError, outContent.toString());
        }
    }

    @Nested
    @DisplayName("Exception Tests")
    class ExceptionTests {

        @Test
        @DisplayName("Non-integer arguments")
        void nonIntegerArguments() {
            String[] args = {"abc", "xyz"};
            assertThrows(NumberFormatException.class, () -> MD1.main(args));
        }

        @Test
        @DisplayName("Missing arguments")
        void missingArguments() {
            String[] args = {};
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> MD1.main(args));
        }
    }
}