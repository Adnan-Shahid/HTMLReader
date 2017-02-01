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

import htmlReader.CollectI10Index;

public class CollectI10IndexTest {
  private CollectI10Index i10Index;
  private String data;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testCollectHTMLData() {
    /*
     * testing if it gets the i10index appropriately from a given string
     * expected output is the i10 index which is 69
     */
    data = "s()adtufhr>i10-index</a></td><td class=\"cit-borderleft cit-data\">"
        + "12371</td><td class=\"cit-borderleft cit-data\""
        + ">69</td></tr>some random data >i10-index that goes here";
    i10Index = new CollectI10Index(data);
    assertEquals("69", i10Index.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataNoi10Index() {
    /*
     * testing if returns a 0 when there is no i10Index expected output is 0 as
     * there is no i10Index value
     */
    data = "s()adtufhr>i10-index</a></td><td class=\"cit-borderleft cit-data\">"
        + "12371</td><td class=\"cit-borderleft cit-data\""
        + "Nothing here/td></tr>some random data >i10-index that goes here";
    i10Index = new CollectI10Index(data);
    assertEquals("0", i10Index.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataLettersInsteadOfNumbers() {
    /*
     * testing if it returns a 0 when there is no i10 index case where there are
     * letters where the index is supposed to be expected output is 0 as there
     * is no i10 index amount
     */
    data = "s()adtufhr>i10-index</a></td><td class=\"cit-borderleft cit-data\">"
        + "12371</td><td class=\"cit-borderleft cit-data\""
        + ">alphabet</td></tr>some random data >i10-index that goes here";
    i10Index = new CollectI10Index(data);
    assertEquals("0", i10Index.CollectHTMLData());
  }

  @Test
  public void testCollectHTMLDataEmptySpace() {
    /*
     * testing if it returns a 0 when there is no i10 index and the expected
     * area for the index has nothing inside is no i10 index amount
     */
    data = "s()adtufhr>i10-index</a></td><td class=\"cit-borderleft cit-data\">"
        + "12371</td><td class=\"cit-borderleft cit-data\""
        + "></td></tr>some random data >i10-index that goes here";
    i10Index = new CollectI10Index(data);
    assertEquals("0", i10Index.CollectHTMLData());
  }



}
