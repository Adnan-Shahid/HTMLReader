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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectCoAuthors extends CollectData {
  // Holds the regex to match the html for coauthors
  private static String regex = "title=\"[^\"]*\">([^<]*)<\\/a><br>";
  private Vector<String> coAuthors;


  /**
   * Basic constructor for the class
   * 
   * @param HTML, contains raw html data to match with a regex
   */
  public CollectCoAuthors(String HTML) {
    // calling the constructor of the parent to intialize pattern and
    // matcher objects
    super(HTML, regex);
    coAuthors = new Vector<String>();
  }

  /**
   * Scans the raw html data and collects data of the coauthors
   * 
   * @return a string that contains the amount of coauthors
   */
  public String CollectHTMLData() {
    try {
      // scan through the html for matches that contain the coauthors
      while (super.matcherObject.find()) {
        // Only adds the coauthor if it is not already added
        if (!coAuthors.contains(matcherObject.group(1))) {
          // adding the coauthor to the coauthor vector
          coAuthors.add(matcherObject.group(1));
        }
      }

    } catch (Exception e) {
      System.out
          .println("malformed URL or cannot open connection to " + "given URL");
    }
    // return the size of the coAuthors vector as that is the amount of
    // coAuthors there are
    String sizeOfCoAuthors = Integer.toString(coAuthors.size());
    // If there is nothing inside, add a string stating None
    if (coAuthors.size() == 0) {
      coAuthors.add("None");
    }
    return sizeOfCoAuthors;
  }

  /**
   * Returns the vector containing the coAuthors of the raw html
   * 
   * @return coAuthors, a vector containing all coAuthors of the html data
   */
  public Vector<String> getCoAuthors() {
    return this.coAuthors;
  }
}
