package textGenerator;

import utilities.Properties;
import utilities.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Text Generator class takes trigram map generated from TrigramGenerator and generates a text output
 * 
 *
 */

public class TextGenerator {

	private int textLength;
	private String resultingText;

	public TextGenerator() {
		this.textLength = Properties.maximumOutputLength;
		this.resultingText = Properties.resultingText;
	}

	public void setTextLength(Integer textLength) {
		this.textLength = textLength;
	}

	public String getResultingText() {
		return this.resultingText;
	}

	public void joinText(List<String> generatedList) {
		StringBuilder generatedText = new StringBuilder();
		for (String s : generatedList) {
			generatedText.append(s);
			generatedText.append(" ");
		}
		this.resultingText = generatedText.substring(0, generatedText.length() - 1);
	}

	public void generateText(Map<String, ArrayList<String>> trigram) {
		List<String> generatedList = new ArrayList<>();
		List<String> trigramKeys = new ArrayList<>(trigram.keySet());
		String startingWords = trigramKeys.get(Helper.randomChoice(trigramKeys.size()));
		generatedList.add(Helper.separate(startingWords).get(0));
		generatedList.add(Helper.separate(startingWords).get(1));
		String key = startingWords;
		int lastPositionPointer = 1;
		while (trigram.containsKey(key) && generatedList.size() <= this.textLength) {
			ArrayList<String> nextWordCandidates = trigram.get(key);
			String nextWord = nextWordCandidates.get(Helper.randomChoice(nextWordCandidates.size()));
			if (nextWord.contains(".")) {
				nextWord += "\n";
			}
			generatedList.add(nextWord);
			lastPositionPointer += 1;
			key = Helper.concatenate(Helper.stripKey(generatedList.get(lastPositionPointer - 1)),
			Helper.stripKey(generatedList.get(lastPositionPointer)));
		}
		joinText(generatedList);
		Helper.consolePrint("success", "Text generated!!!");
	}

}
