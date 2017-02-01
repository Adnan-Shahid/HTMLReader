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
package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import htmlReader.*;
import dataOutput.*;

public class MyParser {

  /**
   * Reads user input and extracts all the data
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      // Create a line reader
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // Assess user input endlessly (intended to stop with the exit command)
      // and send the input to into the ProQuery
      String input = br.readLine();
      ProQuery shellQuery = new ProQuery(input);
      shellQuery.extractData();



    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
