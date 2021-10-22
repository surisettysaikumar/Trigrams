# Trigram Generator

This code aims to solve CodeKata:14  http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/

## Overview

* The program was developed using Java 14.0.2 and Junit 5
* This program will take text file as input and generate random, custom length, text into output text file.
## Program Structure
This program was divided into modules to maintain clear understanding of the program flow.
### Utilities Package
This package contains basic utility classes reused in the program.
#### Properties.java  
This class contains constants used in the program such as Input file,output file,log file directories,TextLength etc.
#### Helper.java
This class contains helper methods such as consolePrint,Wordcount,randomChoice etc used in different areas of the program.
#### CustomLogger.java
This class logs with timestamps all the activity performed by a given user in a specified logfile.This can be useful in production environment to set up monitoring or to debug specific issues
### Main Package
This contains Main.java class which is the entry of this program. It contains sequence of operations to be perfomed, takes input file and generates output file
### fileIO Package
#### fileInputOutput.java 
This class is responsible for read/write file operations
### Trigram Generator Package
#### TrigramGenerator.java
This class generates a trigram map by using the list of words extracted from input text file.
### Text Generator Package
#### TextGenerator.java
This class generates text by choosing a random couple of words to start building the text, then chooses a random value from the trigram. The subsequent two words, stripped of their characters are used to find a next match. The result is a List of strings, which is then concatenated adding spaces.
### Testcases Package
This contains JUnit testcases checking input/output operations of file,Text Generator test and Trigram Map generation test.
Test sources package contains some sample input text files for Junit Test cases.
### Resources
This has three sample input text files to run this program( To test different input file, change input file name in properties file)
### Output
This has the final output text file with filename including input file,timestamp generated with the input file considered.
### Logs
This has executionLog.log file which captures the log and stores into this file.
### Future improvements
concurrency implementation
