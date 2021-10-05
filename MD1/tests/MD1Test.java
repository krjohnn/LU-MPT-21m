import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class MD1Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@Test
	void test() {
		assertEquals(2, 1+1);
		String[] input = new String[2];
		input[0] = "1";
		input[1] = "1";
		MD1.main(input);
		assertEquals(" + \n1234567890123456789012345678901234567890123456789012345678901234567890", outContent.toString());
//		assertEquals(MD1.))
//		fail("Not yet implemented");
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}

}
