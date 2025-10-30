import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class DominoTest {

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
        @DisplayName("Standard valid input (2 players)")
        void standardValidInput() {
            String[] args = {"2"};
            Domino.main(args);
            String output = outContent.toString();
            assertTrue(output.contains("1.speletajam ir:"));
            assertTrue(output.contains("2.speletajam ir:"));
        }

        @Test
        @DisplayName("Valid input (4 players) with domino format validation")
        void validInputFourPlayersWithDominoPattern() {
            String[] args = {"4"};
            Domino.main(args);
            String output = outContent.toString();

            // This regex validates the output for four players in order.
            // It also enforces that each player has at least one domino
            // matching the "digit-digit " pattern.
            String dominoPattern = "\\s*(\\d-\\d\\s)+"; // A reusable pattern for the dominoes

            String regex = "(?s).*"
                    + "1\\.speletajam ir:" + dominoPattern
                    + "2\\.speletajam ir:" + dominoPattern
                    + "3\\.speletajam ir:" + dominoPattern
                    + "4\\.speletajam ir:" + dominoPattern;
            originalOut.println(output);
            originalOut.println(regex);
            assertTrue(output.matches(regex),
                    "Output should contain formatted dominoes (e.g., '1-2 3-4 ') for all 4 players in order.");
        }
    }

    @Nested
    @DisplayName("Invalid Input Tests")
    class InvalidInputTests {

        @Test
        @DisplayName("Invalid input (0 players)")
        void invalidInputZeroPlayers() {
            String[] args = {"0"};
            Exception exception = assertThrows(ArithmeticException.class, () -> Domino.main(args));
            assertEquals("/ by zero", exception.getMessage());
        }

        @Test
        @DisplayName("Invalid input (negative players)")
        void invalidInputNegativePlayers() {
            String[] args = {"-3"};
            Domino.main(args);
            String output = outContent.toString();
            assertTrue(output.isEmpty());
        }
    }

    @Nested
    @DisplayName("Exception Tests")
    class ExceptionTests {

        @Test
        @DisplayName("Non-integer arguments")
        void nonIntegerArguments() {
            String[] args = {"abc"};
            assertThrows(NumberFormatException.class, () -> Domino.main(args));
        }

        @Test
        @DisplayName("Missing arguments")
        void missingArguments() {
            String[] args = {};
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> Domino.main(args));
        }
    }
}