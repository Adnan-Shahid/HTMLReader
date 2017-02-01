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

public class CollectData {
  public String HTML;
  public String regex;
  public Pattern patternObject;
  public Matcher matcherObject;

  /**
   * Parent constructor for all the collecting data classes Initializes pattern
   * and matcher objects with a given regex
   * 
   * @param HTML, HTML data to parse through
   * @param regex, regex to match the string
   */
  public CollectData(String HTML, String regex) {
    this.HTML = HTML;
    this.regex = regex;
    // Pattern object that holds the regex
    this.patternObject = Pattern.compile(regex);
    // matcher object to math the regex pattern with the given html
    this.matcherObject = patternObject.matcher(HTML);
  }
}

