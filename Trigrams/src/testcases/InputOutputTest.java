package testcases;

import org.junit.jupiter.api.Test;
import fileIO.FileInputOutput;
import utilities.Properties;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class InputOutputTest {
	FileInputOutput inputOutput = new FileInputOutput();

    @Test
    void testSmallInputFile() {
        File testFile = new File("src/test/sources/example.txt");
        inputOutput.readFile(testFile);
        List<String> expectedText = new ArrayList<String>();
        expectedText.add("I wish I may I wish I might");
        assertEquals(expectedText,inputOutput.getInputText());
    }

    
    @Test
    void testMultipleLinesInputFile() {
        File testFile = new File("src/test/sources/LoremIpsum.txt");
        inputOutput.readFile(testFile);
        List<String> expectedText = new ArrayList<String>();
        expectedText.add("Lorem ipsum dolor sit amet, consectetur adipiscing eli.");
        expectedText.add("Nullam eget ante quis risus imperdiet scelerisque.");
        expectedText.add("Fusce eget vestibulum odio.");
        expectedText.add("Etiam ut neque erat.");
        expectedText.add("Donec ut ex iaculis, tincidunt sapien a, consequat est.");
        expectedText.add("Praesent luctus arcu eu fringilla laoreet.");
        expectedText.add("Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.");
        assertEquals(expectedText,inputOutput.getInputText());
    }

    @Test
    void testCreatingAFile(){
        File testFile = new File(Properties.outputDirectory + "/" + "test");
        inputOutput.writeToFile("Example","test");
        assertTrue(testFile.exists());
        assertTrue(testFile.delete());
    }

}