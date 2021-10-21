package fileIO;

import utilities.Properties;
import utilities.Helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * FileInputOutput class deals with Input and output handling, reads input from file and writes output to a file
 *
 */

public class FileInputOutput {
	private final List<String> inputText;

	public FileInputOutput() {
		this.inputText = new ArrayList<>();
	}

	public List<String> getInputText() {
		return inputText;
	}

	public void writeToFile(String generatedText, String filename) {
		Path filePath = Paths.get(Properties.outputDirectory + "/" + filename);
		System.out.println(filePath);
		try {
			Files.writeString(filePath, generatedText, StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			Helper.consolePrint("error", "An error occourred while writing to a file");
			Helper.consolePrint("info", e.getMessage());
			System.exit(0);
		}
	}

	public void hasAccess(File file) {
		if (!file.exists() || !file.canRead()) {
			Helper.consolePrint("error", "Error reading " + file.toString() + " Please check your file Access");
			System.exit(0);
		}
	}

	public void readFile(File file) {
		hasAccess(file);
		BufferedReader br = null;
		try {
			String line;
			 FileReader fr = new FileReader(file);
			 br = new BufferedReader(fr);
			 while ((line = br.readLine()) != null) {
				this.inputText.add(line);
			 }
			 br.close();
			 Helper.consolePrint("success", "File read successfully");
		} catch (Exception e) {
			Helper.consolePrint("error", "An error occourred while reading a file");
			Helper.consolePrint("info", e.getMessage());
			System.exit(0);
		}

	}

}
