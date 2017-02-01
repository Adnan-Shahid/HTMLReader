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

public class CollectFirstThreePublications extends CollectData {
  // string that contains the regex that will be used for matching
  private static String regex = "class=\"cit-dark-large-link\">(.*?)</a><br>";
  private String firstThreePublications = "";
  // Stores amount of publications found
  private int counter = 0;

  /**
   * Basic constructor for the class
   * 
   * @param HTML, contains the raw html data to parse through and collect data
   */
  public CollectFirstThreePublications(String HTML) {
    // calling parent class constructor to initialize pattern and matcher
    // objects
    super(HTML, regex);
  }

  /**
   * Collects the first three publications from the given raw html
   * 
   * @return firstThreePublications, a string that contains the first three
   *         publications of the given html
   */
  public String CollectHTMLData() {
    try {
      // scan the entire html data
      while (super.matcherObject.find()) {
        // only add the first 3 publications to the string
        if (counter < 3) {
          // format the string as required upon adding each publication
          firstThreePublications += "\t" + Integer.toString(counter + 1) + "- "
              + matcherObject.group(1) + "\n";
          // increment counter
          counter++;
        }
      }

    } catch (Exception e) {
      System.out
          .println("malformed URL or cannot open connection to " + "given URL");
    }
    return firstThreePublications;
  }

}
