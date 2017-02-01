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
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import htmlReader.CollectAuthorData;

public class CollectAuthorDataTest {

  private CollectAuthorData authorData;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testCollectHTMLData() {
    /*
     * Testing if the class can collect author data from a given string Expected
     * output is the author name, or Adnan Shahid
     */
    authorData = new CollectAuthorData("<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">Adnan Shahid</span>");
    assertEquals("Adnan Shahid", authorData.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataOnlyFirstName() {
    /*
     * Testing if the class can collect author data from a given string when the
     * author only has his first name Expected output is the author name, or
     * Adnan Shahid
     */
    authorData =
        new CollectAuthorData("waka walla <span id=\"cit-name-display\" "
            + "class=\"cit-in-place-nohover\">Adnan</span> bananas");
    assertEquals("Adnan", authorData.CollectHTMLData());
    assertEquals(5,5);
  }

  @Test
  public void testCollectHTMLDataThreeNames() {
    /*
     * Testing if the class can collect author data from a given string when the
     * author has three names Expected output is the author name, or Adnan
     * theman Shahid
     */
    authorData =
        new CollectAuthorData("hi my name is <span id=\"cit-name-display\" "
            + "class=\"cit-in-place-nohover\">Adnan theman Shahid</span> waka");
    assertEquals("Adnan theman Shahid", authorData.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataSpecialChars() {
    /*
     * Testing if the class can collect author data from a given string when the
     * author has special characters Expected output is the author name, or
     * Adnan O'Shah.id
     */
    authorData =
        new CollectAuthorData("hi waka mname<span id=\"cit-name-display\" "
            + "class=\"cit-in-place-nohover\">Adnan O'Shah.id</span> bananas");
    assertEquals("Adnan O'Shah.id", authorData.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataNoAuthor() {
    /*
     * Testing if the class will return an empty string if there is no author
     * Expected output is that it returns an empty string
     */
    authorData =
        new CollectAuthorData("hi waka mname<span id=\"cit-name-display\" "
            + "class=\"cit-in-place-nohover/sdbananas");
    assertEquals("", authorData.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataComplexRegex() {
    /*
     * Testing if the class can collect author data if the regex is slightly
     * more complicated Expected output is the author name, or Adnan Shahid
     */
    authorData = new CollectAuthorData("<spand id=\"cit-name>Random<"
        + "<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">Adnan Shahid</span><Abass rules>");
    assertEquals("Adnan Shahid", authorData.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataMultipleRegexFound() {
    /*
     * Testing if the class can collect author data from a given string Expected
     *  if the regex shows twice, it takes the first one
     * output is the author name, or Adnan Shahid
     */
    authorData = new CollectAuthorData("<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">Adnan Shahid</span>"
        + "<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">Willump Shahid</span>");
    assertEquals("Adnan Shahid", authorData.CollectHTMLData());
  }

}
