// FileReverse.java
// Wilson Au-Yeung
// wwauyeun
// CMPS12M
// April 5,2016
// FileReverse.java when turned into an excecutable jar file allows me to take
// in whatever text document read it, and output each word on a new line in
// another text document. It has a scanner to read in the document, and
// PrintWriter to paste the output on another text document. I have a String
// array token to allow me split the line everytime there is a space or tab, and
// the core of the code is inside a while loop. As long as there is a next line
// in the input document it would keep running. It would trim every line and
// split it into seperate elements in the token array. Then each element of the
// array would go into the string Reverse function and return as reversed and
// would be ouputted into the text document.
import java.io.*;
import java.util.Scanner;

class FileReverse {
  public static void main(String[] args) throws IOException {
    Scanner in = null;
    PrintWriter out = null;
    String token[] = null;
    String line = null;
    int counter = 0;
    // checks if the number of command line arguments is at least two
    if (args.length != 2) {
      System.out.println("Usage: FileReverse <input file> <output file> ");
      System.exit(1);
    }

    // opens the two files
    in = new Scanner(new File(args[0]));
    out = new PrintWriter(new FileWriter(args[1]));
    // read lines from in
    while (in.hasNextLine()) {
      line = in.nextLine().trim() + " ";
      token = line.split("\\s+");

      for (counter = 0; counter < token.length; counter++) {
        int yo = token[counter].length();
        String k = stringReverse(token[counter], yo);
        out.println(k);
      }
    }

    // close files
    in.close();
    out.close();
  }

  public static String stringReverse(String s, int n) {
    if (n == 0) {
      return s;
    } else {
      String reverse = stringReverse(s.substring(1), n - 1) + s.charAt(0);
      return reverse;
    }
  }
}
