package main;

import java.io.File;
import java.text.SimpleDateFormat;
import fileIO.FileInputOutput;
import textGenerator.TextGenerator;
import trigramGenerator.TrigramGenerator;
import utilities.Properties;
import utilities.Helper;

/* Main Function
Takes input file from resources folder with filename defined in properties file.
Trigram map is generated using trigramMapGennerator class
output text is generated using the map produced in above step 
output text is written to a file in output folder
*/

public class Main {
    private static Integer outputLength;
    private static File inputFile;
    private static final FileInputOutput inputOutput = new FileInputOutput();
    private static final TrigramGenerator trigramMapGenerator = new TrigramGenerator();
    private static final TextGenerator textGenerator = new TextGenerator();
       
	public static void main(String args[]) {

		Helper.consolePrint("step", "Welcome to the trigram generator");
		try {
        inputFile =Properties.inputFile;
        inputOutput.readFile(inputFile);
        trigramMapGenerator.generateTrigramMap(inputOutput.getInputText());
        textGenerator.setTextLength(Properties.maximumOutputLength);
        textGenerator.generateText(trigramMapGenerator.getTrigram());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        outputLength=Helper.wordcount(textGenerator.getResultingText());
        inputOutput.writeToFile(textGenerator.getResultingText(), inputFile.getName() + "_" + timeStamp + ".txt");
		}
	   catch (Exception e){
          Helper.consolePrint("info",e.getMessage());
          System.exit(0);
      }
      Helper.consolePrint("info", inputFile + " file generated an output of " + outputLength + " words.");
		
	}

}
