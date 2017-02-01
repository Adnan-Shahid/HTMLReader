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

import htmlReader.GetRawHTML;

public class GetRawHTMLTest {
  private GetRawHTML getRawHTML;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testGetHTMLCorrectHTML() {
    /*
     * Checks if it gets the html data properly Expected output is a string of
     * length 77552
     */
    getRawHTML = new GetRawHTML("sample1.html");
    try {
      String html = getRawHTML.getHTML();
      assertEquals(77552, html.length());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testGetHTMLCorrectHTML2() {
    /*
     * Checks if it gets the html data properly Expected output is a string of
     * length 78369
     */
    getRawHTML = new GetRawHTML("sample2.html");
    try {
      String html = getRawHTML.getHTML();
      assertEquals(78369, html.length());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testGetHTMLInvalidHTML() {
    /*
     * Checks that the html received is empty if invalid Expected output is an
     * empty string
     */
    getRawHTML = new GetRawHTML("sampledawidunawd");
    try {
      String html = getRawHTML.getHTML();
      assertEquals(0, html.length());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testGetHTMLInvalidHTML2() {
    /*
     * Checks that the html received is invalid Expected output is an empty
     * string
     */
    getRawHTML = new GetRawHTML("sample11.html");
    try {
      String html = getRawHTML.getHTML();
      assertEquals(0, html.length());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
