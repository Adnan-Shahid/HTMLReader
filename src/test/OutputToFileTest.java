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

import java.io.File;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import dataOutput.OutputToFile;

public class OutputToFileTest {
  private OutputToFile fileOutput;
  private Vector<String> v1;

  @Before
  public void setUp() throws Exception {
    v1 = new Vector<String>();
    v1.add("stuff that goes in a\nfile");
  }

  @Test
  public void testCheckValidFileName() {
    /*
     * Testing if the function says a valid filename is valid Expected output is
     * true
     */
    fileOutput = new OutputToFile(v1, "files.txt");
    assertTrue(fileOutput.checkValidFileName());
  }

  @Test
  /*
   * Testing if the function says a invalid filename is invalid, case for when
   * it doesn't end with .txt Expected output is false
   */
  public void testCheckValidFileNameNotValid() {
    fileOutput = new OutputToFile(v1, "files.tasxt");
    assertFalse(fileOutput.checkValidFileName());
  }

  @Test
  /*
   * Testing if the function says a invalid filename is invalid, case for when
   * there are special characters Expected output is false
   */
  public void testCheckValidFileNameNotValidSpecialChar() {
    fileOutput = new OutputToFile(v1, "fi.|les.txt");
    assertFalse(fileOutput.checkValidFileName());
  }

  @Test
  public void testOutputCreatedAFile() {
    /*
     * Testing if the output successfully creates a file Expected output is that
     * it does successfully create the file
     */
    fileOutput = new OutputToFile(v1, "files.txt");
    fileOutput.output();
    File testFile = new File("files.txt");
    assertTrue(testFile.exists());
    if (testFile.exists()) {
      testFile.delete();
    }
  }

  @Test
  public void testOutputCreatedAFileWithCorrectName() {
    /*
     * Testing if the output successfully creates a file with the correct name
     * Expected output is that it does successfully create the file with the
     * name files.txt
     */
    fileOutput = new OutputToFile(v1, "files.txt");
    fileOutput.output();
    File testFile = new File("files.txt");
    assertEquals("files.txt", testFile.getName());
    if (testFile.exists()) {
      testFile.delete();
    }
  }
}
