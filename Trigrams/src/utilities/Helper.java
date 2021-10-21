package utilities;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Helper class contains all the supporting methods for remaining classes.
 * 
 *
 */

public class Helper {

	private static final CustomLogger logger = new CustomLogger();

	public Helper() {
	}

	public static void consolePrint(String type, String message) { // Console Displaying and logging event
		String consoleOutput = "[" + Properties.messageType.get(type) + "] : " + message;
		System.out.println(consoleOutput);
		logger.logEvent(consoleOutput);
	}

	public static String stripKey(String key) {
		String regex = "[^a-zA-Z]";
		return key.replaceAll(regex, "").toLowerCase();
	}

	public static String stripValues(String value) {
		String regex = "[^a-zA-Z|,|.|;|:| |]";
		return value.replaceAll(regex, "").toLowerCase();
	}

	public static String concatenate(String element1, String element2) {
		return (element1 + " " + element2);
	}

	public static List<String> separate(String concatenatedKey) {
		return Arrays.asList(concatenatedKey.split(" "));
	}
	
	public static int wordcount(String input) {
		int wordcount=1;
		for(int i = 0; i < input.length(); i++)
		{
			char result = input.charAt(i);
			if((result == ' ' ) || result == '\t') {
				wordcount++;
			}
		}
		return wordcount;
	}

	public static Integer randomChoice(Integer max) {
		return ThreadLocalRandom.current().nextInt(0, max);
	}
}
