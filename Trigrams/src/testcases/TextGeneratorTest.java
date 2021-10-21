package testcases;

import org.junit.jupiter.api.Test;
import textGenerator.TextGenerator;
import trigramGenerator.TrigramGenerator;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

class TextGeneratorTest {
    TrigramGenerator trigramMapGenerator = new TrigramGenerator();
    TextGenerator generator = new TextGenerator();

    @Test
    void generatingTextFlatTrigram() {
        List<String> input = Collections.singletonList("testing flat trigram");
        trigramMapGenerator.generateTrigramMap(input);
        generator.setTextLength(3);
        generator.generateText(trigramMapGenerator.getTrigram());
        String expectedGeneratedText = "testing flat trigram";
        assertEquals(expectedGeneratedText,generator.getResultingText());

    }
}