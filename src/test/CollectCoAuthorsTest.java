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

import htmlReader.CollectCoAuthors;

public class CollectCoAuthorsTest {

  private CollectCoAuthors coAuthors;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testCollectHTMLDataOneCoAuthor() {
    /*
     * Testing if the function can properly extract coAuthor amount when there
     * is one co author Expected output is it returns the amount of coAuthors
     */
    coAuthors =
        new CollectCoAuthors("title=\"Adam Ameur\">Adam Ameur</a><br><a");
    assertEquals("1", coAuthors.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataMultipleCoAuthors() {
    /*
     * Testing if the function can properly extract coAuthor amount when there
     * is one co author Expected output is it returns the amount of coAuthors
     */
    coAuthors = new CollectCoAuthors("title=\"Adam Ameur\">Adam Ameur</a><br><a"
        + "irrelevant information wakwdawdoa*^&W23>asdaowidnma daoasdasdawd"
        + "title=\"WIllup free\">Free Willy</a><br><a" + "more useless stuff"
        + "title=\"twerk\">Tough Tests Bro</a><br><a");
    assertEquals("3", coAuthors.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataNoCoAuthors() {
    /*
     * Testing if the function works when there are no co authors Expected
     * output is that amount of coauthors is 0
     */
    coAuthors = new CollectCoAuthors("title=\"Adam Ameurnot a legit coauthor");
    assertEquals("0", coAuthors.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataDuplicates() {
    /*
     * Testing if the function doesnt increase the amount of coAuthors if there
     * is a duplicate one Expected Output is 1 coAuthor despite there being his
     * name there twice
     */
    coAuthors = new CollectCoAuthors("title=\"Adam Ameur\">Adam Ameur</a><br><a"
        + "useless stuff" + "title=\"Adam Ameur\">Adam Ameur</a><br><a");
    assertEquals("1", coAuthors.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataMultipleCoAuthorsDuplicates() {
    /*
     * Testing if the function doesn't increase the amount of coAuthors if there
     * is a duplicate one while working with multiple Expected Output is 2
     * coAuthors despite there being one name twice
     */
    coAuthors = new CollectCoAuthors("title=\"Adam Ameur\">Adam Ameur</a><br><a"
        + "irrelevant information wakwdawdoa*^&W23>asdaowidnma daoasdasdawd"
        + "title=\"WIllup free\">Free Willy</a><br><a" + "more useless stuff"
        + "title=\"twerk\">Adam Ameur</a><br><a");
    assertEquals("2", coAuthors.CollectHTMLData());
  }

}
