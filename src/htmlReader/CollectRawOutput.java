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
package htmlReader;

import java.util.Vector;

public class CollectRawOutput {
  // vector that will contain the raw output
  private Vector<String> rawOutput = new Vector<String>();
  private String rawHTML;

  /**
   * Basic constructor for the class
   * 
   * @param HTML, contains the html to extract raw output from
   */
  public CollectRawOutput(String HTML) {
    this.rawHTML = HTML;
  }

  /**
   * Collects all the data from the raw html and returns it
   * 
   * @return rawOutputComplete, a vector that contains both a vector containing
   *         almost all raw output data, and a vector that contains coauthor
   *         data
   */
  public Vector<Vector<String>> CollectRawContents() {
    // Collect and add author data to the vector
    CollectAuthorData authorInfo = new CollectAuthorData(this.rawHTML);
    rawOutput.add(authorInfo.CollectHTMLData());

    // collect and add number of citations to the vector
    CollectNumberCitations amountCitations =
        new CollectNumberCitations(this.rawHTML);
    rawOutput.add(amountCitations.CollectHTMLData());

    // collect and add the i10Index data to the vector
    CollectI10Index i10Index = new CollectI10Index(this.rawHTML);
    rawOutput.add(i10Index.CollectHTMLData());

    // collect and add the first three publications to the vector
    CollectFirstThreePublications firstThreePubs =
        new CollectFirstThreePublications(this.rawHTML);
    rawOutput.add(firstThreePubs.CollectHTMLData());

    // collect and add the first 5 citations to the vector
    CollectFirstFiveCitations collectFirstFiveCitations =
        new CollectFirstFiveCitations(this.rawHTML);
    rawOutput.add(collectFirstFiveCitations.CollectHTMLData());

    // collect and add the co authors to the vector
    CollectCoAuthors collectCoAuthors = new CollectCoAuthors(this.rawHTML);
    rawOutput.add(collectCoAuthors.CollectHTMLData());

    // creating a new vector that will hold all information
    Vector<Vector<String>> rawOutputComplete = new Vector<Vector<String>>();

    // adding already collected data
    rawOutputComplete.add(rawOutput);
    // adding the vector containing the list of coAuthors (by name)
    rawOutputComplete.add(collectCoAuthors.getCoAuthors());

    return rawOutputComplete;
  }

}
