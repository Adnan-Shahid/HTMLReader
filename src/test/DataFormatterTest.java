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

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import dataOutput.DataFormatter;

public class DataFormatterTest {

  private DataFormatter formatter;
  private Vector<String> v1;

  @Before
  public void setUp() throws Exception {
    v1 = new Vector<String>();
    formatter = new DataFormatter(v1);
  }

  @Test
  public void testFormatCoAuthorsSorted() {
    /*
     * Testing that the function sorts the coAuthors successfully Expected
     * output is that in which the output is sorted a b c
     */
    v1.add("b");
    v1.add("a");
    v1.add("c");
    String output = formatter.formatCoAuthors(v1);
    assertEquals("7. Co-Author list sorted (Total:3):\na\nb\nc", output);

  }

  @Test
  public void testFormatCoAuthorsNoDuplicates() {
    /*
     * Testing that the function does not add duplicate coauthors to the output
     * Expected output is that in which the output contains only the unique
     * coauthors
     */
    v1.add("b");
    v1.add("b");
    v1.add("b");
    String output = formatter.formatCoAuthors(v1);
    assertEquals("7. Co-Author list sorted (Total:1):\nb", output);

  }

  @Test
  public void testFormatCoAuthorsNoCoAuthors() {
    /*
     * Testing that the function sends an output that shows no coAuthors
     * Expected output - no coAuthors should be listed and the total should be 0
     */
    String output = formatter.formatCoAuthors(v1);
    System.out.println(output);
    assertEquals("7. Co-Author list sorted (Total:0):", output);

  }

}
