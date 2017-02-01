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
package htmlReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GetRawHTML {
  private String urlString;
  private StringBuilder html;
  private String rawHTML = "";

  /**
   * Basic constructor for the class
   * 
   * @param url, contains the url to extract all the html data from
   */
  public GetRawHTML(String url) {
    // stores url
    this.urlString = url;
  }

  /**
   * Gets the raw html from the given url - NOTE: Code from from A.A that was
   * given
   * 
   * @return rawHTML, contains raw html data from the url
   * @throws Exception
   */
  public String getHTML() throws Exception {
    try {
      // create object to store html source text as it is being collected
      html = new StringBuilder();
      // open connection to given url
      URL url = new File(this.urlString).toURI().toURL();
      // create BufferedReader to buffer the given url's HTML source
      BufferedReader htmlbr =
          new BufferedReader(new InputStreamReader(url.openStream()));
      String line;
      // read each line of HTML code and store in StringBuilder
      while ((line = htmlbr.readLine()) != null) {
        html.append(line);
      }
      htmlbr.close();
    } catch (IOException e) {
      System.out.println("That was an invalid URL");
    }

    // convert StringBuilder into a String
    rawHTML = html.toString();
    // check to make sure the url is a valid google scholar url
    if (!rawHTML.contains("http://scholar.google.ca/citations?user=")) {
      // make the raw HTML data an empty string
      rawHTML = "";
    }

    return rawHTML;
  }
}
