package trigramGenerator;

import utilities.Helper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * trigramGenerator class contains methods help to generate a trigram such as 
 * extractLines(),generateTrigram()
 * 
 *
 */
public class TrigramGenerator {

	private final Map<String, ArrayList<String>> trigram;

	public TrigramGenerator() {
		this.trigram = new HashMap<>();
	}

	public Map<String, ArrayList<String>> getTrigram() {
		return trigram;
	}

	private Boolean hasNext(Integer listSize, Integer recursiveCounter) {
		return recursiveCounter < listSize - 1;
	}

	private void extractLines(List<String> inputText) {
		for (int i = 0; i < inputText.size(); i++) {
			ArrayList<String> input = new ArrayList<>(Arrays.asList(Helper.stripValues(inputText.get(i)).split(" ")));
			input.removeAll(Collections.singletonList(" "));
			input.removeAll(Collections.singletonList(""));
			if (hasNext(inputText.size(), i)) {
				List<String> nextLineBeginning = Arrays.asList(Helper.stripValues(inputText.get(i + 1)).split(" ", 3));
				if (nextLineBeginning.size() > 1) {
					input.add(nextLineBeginning.get(0));
					input.add(nextLineBeginning.get(1));
				}
			}
			if (input.size() < 3) {
				continue;
			}
			generateTrigram(input);
		}
	}
	
	private void generateTrigram(ArrayList<String> input) {
		for (int i = 0; i < input.size() - 2; i++) {
			String trigramKey = Helper.concatenate(Helper.stripKey(input.get(i)), Helper.stripKey(input.get(i + 1)));
			String trigramValue = input.get(i + 2);
			if (trigram.containsKey(trigramKey)) {
				trigram.get(trigramKey).add(trigramValue);
			} else {
				ArrayList<String> trigramValues = new ArrayList<>();
				trigramValues.add(trigramValue);
				trigram.put(trigramKey, trigramValues);
			}
		}
	}


	public void generateTrigramMap(List<String> inputText) {  	// generateTrigramMap() generates Trigram Map
		if (inputText == null || inputText.size() == 0) {
			Helper.consolePrint("error", "Input text is empty");
			System.exit(0);
		}
		extractLines(inputText);
		Helper.consolePrint("success", "Trigram map successfully generated");
	}

}
