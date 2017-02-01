// **********************************************************
// Assignment3:
// UTORID user_name: shahid41
//
// Author: Adnan Shahid
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
package dataOutput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class OutputToFile implements OutputData {
  private Vector<String> allCoAuthors;
  private DataFormatter formatter;
  private String output = "";
  private String fileName;
  private PrintWriter writer;

  /**
   * Basic constructor for the class
   * 
   * @param formattedOutput
   * @param fileName
   */
  public OutputToFile(Vector<String> formattedOutput, String fileName) {
    // Using formatter collaboration
    this.formatter = new DataFormatter(formattedOutput);
    // storing filename
    this.fileName = fileName;
  }

  /**
   * Collects formatted html data and returns it
   * 
   * @return output, contains formatted html data
   */
  public String collectOutputData() {
    this.output = formatter.formatData();
    return this.output;
  }

  /**
   * Returns the string containing all the formatted coauthors
   * 
   * @return coAuthors
   */
  public String outputCoAuthors() {
    // TODO Auto-generated method stub
    String coAuthors = "\n" + formatter.formatCoAuthors(this.allCoAuthors);
    return coAuthors;

  }

  /**
   * Sets the output in the class
   * 
   * @param outputData, contains a string that will hold output data
   */
  public void setOutput(String outputData) {
    this.output = outputData;
  }

  @Override
  /**
   * Prints the formatted data to a file
   */
  public void output() {
    try {
      // Instantiate the writer with the given filename
      this.writer = new PrintWriter(fileName, "UTF-8");
      // split the output data so we can print to file correctly
      String[] splitOutput = output.split("\n");
      // Writing to file
      for (int i = 0; i < splitOutput.length; i++) {
        writer.println(splitOutput[i]);
      }
      // close the writer
      writer.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  /**
   * Sets the coAuthors vector
   * 
   * @param coAuthors
   */
  public void setCoAuthors(Vector<String> coAuthors) {
    // TODO Auto-generated method stub
    this.allCoAuthors = coAuthors;
  }

  /**
   * Checks if the file name in the object is valid or not
   * 
   * @return validFile, a boolean that will return false if the file isn't valid
   */
  public boolean checkValidFileName() {
    // preset that the file is valid
    boolean validFile = true;
    // checking to make sure the file ends with .txt
    if (!this.fileName.endsWith(".txt")) {
      // if not, it's not a valid file
      validFile = false;
    }
    // remove the .txt portion (it is 4 chars)
    String strippedFileName =
        this.fileName.substring(0, this.fileName.length() - 4);
    // array containing invalid chars for a file name
    String[] invalidChars =
        {"\\", "/", ":", "*", "?", ".", "\"", "<", ">", "|"};
    // check the stripped filename to see if it contains the chars
    for (int i = 0; i < invalidChars.length; i++) {
      if (strippedFileName.contains(invalidChars[i])) {
        // if it contains the chars, it's not valid
        validFile = false;
      }
    }
    return validFile;
  }



}
