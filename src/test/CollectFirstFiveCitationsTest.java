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

import htmlReader.CollectFirstFiveCitations;

public class CollectFirstFiveCitationsTest {

  private CollectFirstFiveCitations firstFive;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testCollectHTMLDataTestOneCitationOnly() {
    /*
     * Testing if it collects 1 citation amount properly Expected output is
     * amount of citations (24)
     */
    firstFive =
        new CollectFirstFiveCitations("there are things ehre class=\"cit"
            + "class=\"cit-dark-link\" href=\"somestuff\">24</a></td><td"
            + " more stuff");

    assertEquals("24", firstFive.CollectHTMLData());

  }

  @Test
  public void testCollectHTMLDataTest5Citations() {
    /*
     * Testing if it sums 5 citation amounts properly Expected output is the sum
     * of all 5 citation amounts
     */
    firstFive =
        new CollectFirstFiveCitations("there are things ehre class=\"cit"
            + "class=\"cit-dark-link\" href=\"somestuff\">24</a></td><td"
            + " more stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">2</a></td><td"
            + "stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">2</a></td><td"
            + "stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">3</a></td><td"
            + "more stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">1</a></td><td");

    assertEquals("32", firstFive.CollectHTMLData());

  }

  @Test
  public void testCollectHTMLDataTestMoreThan5Citations() {
    /*
     * Testing if it sums only the first 5 citations amounts Expected output is
     * the sum of the first 5 citation amounts
     */
    firstFive =
        new CollectFirstFiveCitations("there are things ehre class=\"cit"
            + "class=\"cit-dark-link\" href=\"somestuff\">24</a></td><td"
            + " more stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">2</a></td><td"
            + "stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">2</a></td><td"
            + "stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">3</a></td><td"
            + "more stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">1</a></td><td"
            + "more stuff"
            + "class=\"cit-dark-link\" href=\"somestuff\">100</a></td><td");

    assertEquals("32", firstFive.CollectHTMLData());

  }

  @Test
  public void testCollectHTMLDataTestNoCitations() {
    /*
     * Testing if it collects no citations if there are no citations found
     * Expected output is 0 as there are no citations
     */
    firstFive =
        new CollectFirstFiveCitations("there are things ehre class=\"cit"
            + "class=\"cit-dark-link\"a></td><td" + " more stuff");

    assertEquals("0", firstFive.CollectHTMLData());

  }
}
