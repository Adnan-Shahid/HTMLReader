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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class DataFormatter {
  private Vector<String> rawData;
  private String formattedOutput = "";
  private Vector<String> allCoAuthors = new Vector<String>();
  private static final int AUTHORDATA = 0;
  private static final int CITATIONS = 1;
  private static final int I10INDEX = 2;
  private static final int FIRST3PUBS = 3;
  private static final int PAPERCITATIONS = 4;
  private static final int COAUTHORS = 5;

  /**
   * basic constructor for the class
   * 
   * @param rawData, contains the raw data obtained from the html
   */
  public DataFormatter(Vector<String> rawData) {
    this.rawData = rawData;
  }

  /**
   * Formats all data and places it into a string
   * 
   * @return formattedOutput, a string containing formatted data
   */
  public String formatData() {
    // adding formatted author data
    formattedOutput += formatAuthorData();
    // adding formatted citations amount
    formattedOutput += formatNumberCitations();
    // adding formatted i10 index amount
    formattedOutput += formati10Index();
    // adding formatted first three publications
    formattedOutput += formatFirstThreePubs();
    // adding formatted total paper citations (first 5)
    formattedOutput += formatTotalPaperCitations();
    // adding formatted total coauthors amount
    formattedOutput += formatTotalCoAuthors();
    // adding the line as per format
    formattedOutput += "------------------------------------";

    return formattedOutput;
  }

  /**
   * formats author data as per requirements
   * 
   * @return authorData, string containing formatted data
   */
  public String formatAuthorData() {
    // formatting data
    String authorData = "\n1. Name of Author:\n\t" + rawData.get(AUTHORDATA);
    return authorData;
  }

  /**
   * formats number of citations data as per requirements
   * 
   * @return numbercitations, string containing formatted data
   */
  public String formatNumberCitations() {
    // formatting data
    String numberCitations =
        "\n2. Number of All Citations:\n\t" + rawData.get(CITATIONS);
    return numberCitations;
  }

  /**
   * formats i10index data as per requirements
   * 
   * @return i10Index, string containing formatted data
   */
  public String formati10Index() {
    // formatting data
    String i10Index =
        "\n3. Number of i10-index after 2009:\n\t" + rawData.get(I10INDEX);
    return i10Index;
  }

  /**
   * formats first three publications data as per requirements
   * 
   * @return firstThreePubs, string containing formatted data
   */
  public String formatFirstThreePubs() {
    // formatting data
    String firstThreePubs =
        "\n4. Title of the first 3 publications:\n" + rawData.get(FIRST3PUBS);
    return firstThreePubs;
  }

  /**
   * formats total paper citations (first 5) data as per requirements
   * 
   * @return totalPaperCitation, string containing formatted data
   */
  public String formatTotalPaperCitations() {
    // formatting data
    String totalPaperCitation =
        "\n5. Total paper citation (first 5 papers):\n\t"
            + rawData.get(PAPERCITATIONS);
    return totalPaperCitation;
  }

  /**
   * formats coauthor data as per requirements
   * 
   * @return totaCoAuthors, string containing formatted data
   */
  public String formatTotalCoAuthors() {
    // formatting data
    String totalCoAuthors =
        "\n6. Total Co-Authors:\n\t" + rawData.get(COAUTHORS) + "\n";
    return totalCoAuthors;
  }


  /**
   * formats coAuthor vector into a string as per requirements
   * 
   * @param coAuthors, a vector containing all coAuthor names
   * @return output, returns total output
   */
  public String formatCoAuthors(Vector<String> coAuthors) {
    // stores amount of coAuthors
    int counter = 0;
    // stores output data
    String output = "";

    // sorting the vector
    Collections.sort(coAuthors);

    // add to output for each coAuthor
    for (int i = 0; i < coAuthors.size(); i++) {
      // removing duplicates
      if (!output.contains(coAuthors.get(i))) {
        // format of data
        output += "\n" + coAuthors.get(i);
        // increment counter
        counter++;
      }
    }
    // format of data
    output = "7. Co-Author list sorted (Total:" + counter + "):" + output;
    return output;

  }


}
