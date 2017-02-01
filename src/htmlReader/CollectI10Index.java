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


public class CollectI10Index extends CollectData {
  // String that contains the regex that will be used for matching to get
  // the I10Index since 2009 publications
  private static String regex =
      ">i10-index</a></td><td class=\"cit-borderleft cit-data\">"
          + "(\\d*)</td><td class=\"cit-borderleft cit-data\""
          + ">(\\d+)</td></tr>";
  // default i10IndexAmount to 0 if there are none
  private String i10IndexAmount = "0";

  /**
   * Basic constructor for the class
   * 
   * @param HTML, contains the raw html data to match for the regex
   */
  public CollectI10Index(String HTML) {
    // Calling parent constructor to initialize pattern and matcher objects
    super(HTML, regex);
  }

  /**
   * Collects the I10Index since 2009 data value from the given HTML data
   * 
   * @return i10IndexAmount, contains number of i10-index since 2009
   */
  public String CollectHTMLData() {
    try {
      // scan through the html data to find i10index amount
      while (super.matcherObject.find()) {
        // Store the value
        i10IndexAmount = matcherObject.group(2);
      }

    } catch (Exception e) {
      System.out
          .println("malformed URL or cannot open connection to " + "given URL");
    }
    return i10IndexAmount;
  }


}
