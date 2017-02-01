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


public class CollectAuthorData extends CollectData {
  // Static string containing the regex to get the authors data
  private static String regex = "<span id=\"cit-name-display\" "
      + "class=\"cit-in-place-nohover\">(.*?)</span>";
  // String to hold author name
  private String authorName = "";

  /**
   * Basic constructor to collect author name
   * 
   * @param HTML, given html to parse through
   */
  public CollectAuthorData(String HTML) {
    // Calling parent constructor to make pattern and matcher objects with the
    // regex
    super(HTML, regex);
  }

  /**
   * Collects the Author name from the given html
   * 
   * @return authorName, returns the author name
   */
  public String CollectHTMLData() {
    try {
      // Checking for author name from the given html
      if (super.matcherObject.find()) {
        // storing author name
        authorName = matcherObject.group(1);
      }

    } catch (Exception e) {
      System.out
          .println("malformed URL or cannot open connection to " + "given URL");
    }
    return authorName;
  }


}
