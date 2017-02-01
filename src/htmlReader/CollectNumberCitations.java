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

public class CollectNumberCitations extends CollectData {
  // String that holds the regex that will be matched with the html data
  private static String regex = "cit-data\">(\\d+)</td>";
  private String totalCitations = "0";

  /**
   * Basic constructor for the class
   * 
   * @param HTML, holds the raw html data to match a given regex to
   */
  public CollectNumberCitations(String HTML) {
    // calling parent constructor to initialize pattern and matcher objects
    super(HTML, regex);
  }

  /**
   * Collects the total number of citations of the given html data
   * 
   * @return totalCitations, contains total citations from raw html
   */
  public String CollectHTMLData() {
    try {
      // take the first occurance of the pattern as that is the total citations
      if (super.matcherObject.find()) {
        totalCitations = matcherObject.group(1);
      }

    } catch (Exception e) {
      System.out
          .println("malformed URL or cannot open connection to " + "given URL");
    }
    return totalCitations;
  }

}
