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

import htmlReader.ProQuery;

public class ProQueryTest {
  private ProQuery pq;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testExtractData() {
    /*
     * Testing if the data inside proquery has changed after extracting html
     * data
     */
    pq = new ProQuery("sample1.html");
    try {
      pq.extractData();
      assertTrue(pq.getRawOutput().size() > 0);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testExtractDataMultipleStatements() {
    /*
     * Testing if the data inside proquery has changed after extracting html
     * data with two htmls to scan through
     */
    pq = new ProQuery("sample1.html,sample2.html");
    try {
      pq.extractData();
      assertTrue(pq.getRawOutput().size() > 0);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testExtractDataMultipleArgs() {
    /*
     * Testing if the data inside proquery has changed after extracting html
     * data with 2 arguements
     */
    pq = new ProQuery("sample1.html,sample2.html files.txt");
    try {
      pq.extractData();
      assertTrue(pq.getRawOutput().size() > 0);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testExtractDataInvalidHTML() {
    /*
     * Testing if the data inside proquery has not change with an invalid html
     * data
     */
    pq = new ProQuery("ssdaoiwmdw2.html");
    try {
      pq.extractData();
      assertTrue(pq.getRawOutput().size() == 0);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testExtractDataInvalidHTML2() {
    /*
     * Testing if the data inside proquery has not change with an invalid html
     * data
     */
    pq = new ProQuery("sample2.htwml");
    try {
      pq.extractData();
      assertTrue(pq.getRawOutput().size() == 0);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
