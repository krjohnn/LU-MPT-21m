import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class MD3Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Nested
    @DisplayName("Valid Input Tests")
    class ValidInputTests {

        @Test
        @DisplayName("Standard valid input (0, 0)")
        void standardValidInputDoubleZero() {
            String[] args = {"0", "0"};
            MD3.main(args);
            String output = outContent.toString();
            String expectedOutput = "0\n0\n0\n0\n";
            assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        @DisplayName("Standard valid input (1530, 1530)")
        void standardValidInputPosInt() {
            String[] args = {"1530", "1530"};
            MD3.main(args);
            String output = outContent.toString();
            String expectedOutput = "3060\n603\n927\n729\n";
            assertEquals(expectedOutput, outContent.toString());
        }
    }
}