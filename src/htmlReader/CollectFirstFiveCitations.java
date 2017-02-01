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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectFirstFiveCitations extends CollectData {
  // static string that will be used to match the html for first five citations
  private static String regex =
      "class=\"cit-dark-link\" href=\"(.*?)\">(\\d*)</a></td><td";
  private String firstFiveCitations = "";
  private int totalCitations = 0;
  // Stores amount of paper citations taken
  private int counter = 0;

  /**
   * Basic constructor for the class
   * 
   * @param HTML, the html data to parse through
   */
  public CollectFirstFiveCitations(String HTML) {
    // Using the parent class to make the pattern and matcher objects with
    // the given regex
    super(HTML, regex);
  }

  /**
   * Used to collect the total citations from the first 5 papers in the raw html
   * data
   * 
   * @return firstFiveCitations, a string containing the paper citations in the
   *         first 5 papers
   */
  public String CollectHTMLData() {
    try {
      // Check if the regex matches
      while (super.matcherObject.find()) {
        // if there is not 5 paper citation amounts taken already
        if (counter < 5) {
          // add to the total citations
          totalCitations += Integer.parseInt(matcherObject.group(2));
          // increment the counter
          counter++;
        }
      }
      // change to a string
      firstFiveCitations = Integer.toString(totalCitations);

    } catch (Exception e) {
      System.out
          .println("malformed URL or cannot open connection to " + "given URL");
    }
    return firstFiveCitations;
  }
}
