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

import java.util.Vector;

public class OutputToConsole implements OutputData {
  private Vector<String> allCoAuthors;
  private DataFormatter formatter;

  /**
   * Basic constructor for the class
   * 
   * @param formattedOutput, contains formatted output to output to console
   */
  public OutputToConsole(Vector<String> formattedOutput) {
    // using a formatter collaboration
    this.formatter = new DataFormatter(formattedOutput);
  }

  @Override
  /**
   * outputs data to console
   */
  public void output() {
    // outputting formatted data
    System.out.println(formatter.formatData());
  }

  @Override
  /**
   * sets the allCoAuthors vector
   * 
   * @param coAuthors
   */
  public void setCoAuthors(Vector<String> coAuthors) {
    this.allCoAuthors = coAuthors;
  }

  /**
   * Prints the allCoAuthors vector
   */
  public void outputCoAuthors() {
    // printing the formatted vector
    System.out.println(formatter.formatCoAuthors(allCoAuthors));
  }

}
