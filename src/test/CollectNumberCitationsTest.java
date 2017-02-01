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

import htmlReader.CollectNumberCitations;

public class CollectNumberCitationsTest {

  private CollectNumberCitations numberCitations;
  private String data;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testCollectHTMLData() {
    /*
     * Testing if function can correctly pull citations from data Expected
     * output is number of citations (123)
     */
    data = "things are here cit-data\"cit-data\">123</td>and<thingshere>sa^";
    numberCitations = new CollectNumberCitations(data);
    assertEquals("123", numberCitations.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataNoCitations() {
    /*
     * Testing if function returns a 0 when no citations are there Expected
     * output is number of citations (0)
     */
    data = "things are here cit-data\"cit-data\"asdw/td>and<thingshere>sa^";
    numberCitations = new CollectNumberCitations(data);
    assertEquals("0", numberCitations.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataNoCitationsEmptyPlace() {
    /*
     * Testing if function returns a 0 when no citations are there and the
     * expected area for citations is empty Expected output is number of
     * citations (0)
     */
    data = "things are here cit-data\"cit-data\"></td>and<thingshere>sa^";
    numberCitations = new CollectNumberCitations(data);
    assertEquals("0", numberCitations.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataLettersInsteadofNumbers() {
    /*
     * Testing if function returns a 0 when no citations are there Expected
     * output is number of citations (0)
     */
    data = "things are here cit-data\"cit-data\">asd</td>and<thingshere>sa^";
    numberCitations = new CollectNumberCitations(data);
    assertEquals("0", numberCitations.CollectHTMLData());
  }

}
