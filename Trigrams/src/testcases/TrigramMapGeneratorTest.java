package testcases;

import org.junit.jupiter.api.Test;

import trigramGenerator.TrigramGenerator;
import utilities.Helper;
import java.util.*;
import static org.junit.Assert.assertEquals;
@SuppressWarnings("serial")


class TrigramMapGeneratorTest {
    TrigramGenerator trigramMapGenerator = new TrigramGenerator();

	@Test
    void generateTrigram() {
        List<String> input = Collections.singletonList("I wish I may I wish I might");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("i wish", new ArrayList<String>() {{add("i"); add("i"); }});
        expectedTrigram.put("wish i", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may i", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("i may", new ArrayList<String>() {{add("i"); }});
        trigramMapGenerator.generateTrigramMap(input);
        Map<String, ArrayList<String>> actualTrigram = trigramMapGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

	@Test
    void generateMultilineTrigram() {
        List<String> input = Arrays.asList("I wish I may I wish I might","Did I wish");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("i wish", new ArrayList<String>() {{add("i"); add("i"); }});
        expectedTrigram.put("wish i", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may i", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("i may", new ArrayList<String>() {{add("i"); }});
        expectedTrigram.put("i might", new ArrayList<String>() {{add("did"); }});
        expectedTrigram.put("did i", new ArrayList<String>() {{add("wish"); }});
        expectedTrigram.put("might did", new ArrayList<String>() {{add("i"); }});
        trigramMapGenerator.generateTrigramMap(input);
        Map<String, ArrayList<String>> actualTrigram = trigramMapGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void concatenateMultipleLines() {
        List<String> input = Arrays.asList("I","like books");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("i like", new ArrayList<String>() {{add("books");}});
        trigramMapGenerator.generateTrigramMap(input);
        Map<String, ArrayList<String>> actualTrigram = trigramMapGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void skipShortUnconcatenatedLines() {
        List<String> input = Arrays.asList("I","like","reading books");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("like reading", new ArrayList<String>() {{add("books");}});
        trigramMapGenerator.generateTrigramMap(input);
        Map<String, ArrayList<String>> actualTrigram = trigramMapGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void testStrippingKeys(){
        String input = "keys Must, Not!{Have Any' non-alpha^Character";
        String expectedKey = "keysmustnothaveanynonalphacharacter";
        String actualKey = Helper.stripKey(input);
        assertEquals(expectedKey, actualKey);
    }

    @Test
    void testStrippingText() {
        String input = "The text( can, have;^ some punctuation.";
        String expectedValue = "the text can, have; some punctuation.";
        String actualValue = Helper.stripValues(input);
        assertEquals(expectedValue, actualValue);
    }

}