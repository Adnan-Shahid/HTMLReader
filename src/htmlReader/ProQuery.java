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

import java.util.Vector;

import dataOutput.OutputToConsole;
import dataOutput.OutputToFile;

public class ProQuery {
  private String[] args;
  private String[] urls;
  private String outputData = "";
  private String rawHTMLData;
  private Vector<Vector<String>> rawOutput;
  private Vector<String> allCoAuthors = new Vector<String>();

  /**
   * Contains the basic constructor for the class
   * 
   * @param input, stores user input
   */
  public ProQuery(String input) {
    // holds all the string array for all the arguements
    this.args = input.split("\\s+");
    // gets all the individual htmls/urls given in the arguement
    this.urls = args[0].split(",");
  }

  /**
   * Extracts all the data from the given url and outputs it to console or a
   * file depending on user input
   * 
   * @throws Exception
   */
  public void extractData() throws Exception {
    // checks to make sure that there is only 1 or 2 arguements
    if (args.length == 1 || args.length == 2) {
      // Collect all the information of all htmls
      for (int i = 0; i < urls.length; i++) {
        // Create the getRAWHTML class instance with the given string url
        GetRawHTML getRawHTML = new GetRawHTML(urls[i]);
        // get the raw html data
        this.rawHTMLData = getRawHTML.getHTML();
        // only works if html is valid
        if (!this.rawHTMLData.isEmpty()) {
          // instantiating CollectRawOutput class
          CollectRawOutput collectRawOutput =
              new CollectRawOutput(this.rawHTMLData);

          // collecting the raw output
          rawOutput = collectRawOutput.CollectRawContents();
          // added to coAuthors vector
          allCoAuthors.addAll(rawOutput.get(1));

          // if there is no file writing
          if (args.length == 1) {
            // instantiating the OutputToConsole class
            OutputToConsole consoleOutput =
                new OutputToConsole(rawOutput.get(0));
            // prints the data from the html
            consoleOutput.output();
            // if the last html is read and output
            if (i == urls.length - 1) {
              // output the list of coAuthors
              consoleOutput.setCoAuthors(allCoAuthors);
              consoleOutput.outputCoAuthors();
            }
          }
          // case for filewriting
          else {
            // instantiate the OutputToFile class
            OutputToFile fileOutput =
                new OutputToFile(rawOutput.get(0), args[1]);
            // check if the filename is valid
            if (fileOutput.checkValidFileName()) {
              // add to data to be output
              outputData += fileOutput.collectOutputData();
              // when all the data is added from all the urls
              if (i == urls.length - 1) {
                // add the coAuthor data
                fileOutput.setCoAuthors(allCoAuthors);
                outputData += fileOutput.outputCoAuthors();
                // write to the file all data
                fileOutput.setOutput(outputData);
                fileOutput.output();
              }
            } else {
              // output if invalid filename
              System.out.println("Invalid filename");
            }

          }
        } else {
          // if invalid html
          System.out.println("Must enter a valid google scholar html");
        }
      }

    } else {
      // if invalid input
      System.out.println("That was an invalid input");
    }
  }

  /**
   * returns the raw output vector that holds all information used for testing
   * 
   * @return rawOutput, the vector that holds all the data from html
   */
  public Vector<Vector<String>> getRawOutput() {
    return this.rawOutput;
  }
}
