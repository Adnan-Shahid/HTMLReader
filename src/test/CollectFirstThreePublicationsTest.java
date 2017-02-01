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

import htmlReader.CollectFirstThreePublications;

public class CollectFirstThreePublicationsTest {

  private CollectFirstThreePublications firstThreePubs;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testCollectHTMLData3Pubs() {
    /*
     * Testing that the function collects the data of the first 3 pubs Expected
     * output is the titles of the first 3 publications with their num in order
     */
    String data = "stuff" + "class=\"cit-dark-large-link\">Theory</a><br>"
        + "more stuffasd$@S" + "class=\"cit-dark-large-link\">of</a><br>"
        + "stuff" + "class=\"cit-dark-large-link\">poop</a><br>" + "stuff";
    firstThreePubs = new CollectFirstThreePublications(data);
    assertEquals("\t1- Theory\n\t2- of\n\t3- poop\n",
        firstThreePubs.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataMoreThan3Pubs() {
    /*
     * Testing that the function collects the data of only the first 3
     * publications when there are more Expected output is the titles of the
     * first 3 publications with their num in order
     */
    String data = "stuff" + "class=\"cit-dark-large-link\">Theory</a><br>"
        + "more stuffasd$@S" + "class=\"cit-dark-large-link\">of</a><br>"
        + "stuff" + "class=\"cit-dark-large-link\">poop</a><br>" + "stuff"
        + "class=\"cit-dark-large-link\">-AndMore</a><br>" + "stuff"
        + "class=\"cit-dark-large-link\">Digestives</a><br>";
    firstThreePubs = new CollectFirstThreePublications(data);
    assertEquals("\t1- Theory\n\t2- of\n\t3- poop\n",
        firstThreePubs.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataLessThan3Pubs() {
    /*
     * Testing that the function collects the data of all publications when
     * there are less than three Expected output is the titles of the
     * publications in format
     */
    String data = "stuff" + "class=\"cit-dark-large-link\">Theory</a><br>"
        + "more stuffasd$@S" + "class=\"cit-dark-large-link\">of</a><br>"
        + "stuff";
    firstThreePubs = new CollectFirstThreePublications(data);
    assertEquals("\t1- Theory\n\t2- of\n", firstThreePubs.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataNoPubs() {
    /*
     * Testing that the function returns an empty string when there are no
     * publications to find Expected output is an empty string
     */
    String data = "stuff" + "class=\"cit-dark-lsaarge-link\">Theorsy/aasd><br>"
        + "more stuffasd$@S" + "clsdaass=\"cit-dark-large-liasdnk\"oasf</a><br>"
        + "stuff";
    firstThreePubs = new CollectFirstThreePublications(data);
    assertEquals("", firstThreePubs.CollectHTMLData());
  }

}
