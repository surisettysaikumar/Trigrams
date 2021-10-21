package utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Properties class contains all the required information of input/output file
 * directory,max output length etc.
 * 
 *
 */

public class Properties {

	public static final File inputFile = new File("src/resources/input.txt");
	public static final File outputDirectory = new File("src/output");
	public static final File logfileDirectory = new File("src/logs/executionLog.log");
	public static final Integer minimumOutputLength = 3;
	public static final Integer maximumOutputLength = 1000;
	public static final String resultingText = "Error";
	public static final Map<String, String> messageType = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("info", "?");
			put("step", "*");
			put("success", "success");
			put("error", "!");
		}
	};

	private Properties() {
	}
}
