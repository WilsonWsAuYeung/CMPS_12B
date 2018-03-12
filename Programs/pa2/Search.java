//-------------------------------------------------------------------------------------------
// Search.java
// Wilson Au-Yeung
// wwauyeun
// CMPS12B
// April 15,2015
// We were told to create a program to search for target words inside a file.
// Binary Search, we were able  to compare each word in the file to the target
// word. But since Binary Search only works if everything in  the array were in
// order or has at least a way to rank them. We had to use MergeSort to
// basically split  the whole text file into a single String array that held all
// the words, and sorted them in alphabetical  order. Then Binary Search could
// be implemented on the sorted array
import java.io.*;
import java.util.Scanner;
class Search {
  public static void main(String[] args) throws IOException {
    Scanner in = null;
    int lineCounter = 0;
    if (args.length < 2) {
      System.out.println("Usage: Search <input file> <target>");
      System.exit(1);
    }
    in = new Scanner(new File(args[0]));
    while (in.hasNextLine()) {
      in.nextLine();
      lineCounter++;
    }
    in.close();
    in = new Scanner(new File(args[0]));
    // String array to store words from the in file
    String[] dictionary = new String[lineCounter];
    for (int i = 0; i < dictionary.length; i++) {
      dictionary[i] = in.nextLine().trim();
    }
    int[] finalLine = new int[lineCounter];
    // Array to store indices of lines
    for (int i = 0; i < lineCounter; i++) {
      finalLine[i] = i + 1;
    }
    // Sorts the words read in from the in file in alphabetical order
    mergeSort(dictionary, finalLine, 0, dictionary.length - 1);
    // Prints out whether the target is found and where it is found
    for (int i = 1; i < args.length; i++) {
      String ifFound = binarySearch(dictionary, finalLine, 0,
                                    dictionary.length - 1, args[i]);
      System.out.println(args[i] + ifFound);
    }
    // Tests if mergesort sorts the words read from the in file in alphabetical
    // order
    /*for(int i = 0; i < dictionary.length;i++){
            System.out.println(dictionary[i]+" ");
    }*/

    // System.out.println(binarySearch(dictionary,0,dictionary.length-1,args[1]));

    // Tests if indices were assigned after mergesort
    /*for(int i = 0; i < lineCounter;i++){
            System.out.println(finalLine[i]+" ");
    }*/
    in.close();
  }
  // This function basically compares all the values/elements of the String
  // Array and assigns the subarray accordingly from a - z  The lineNumber array
  // basically goes from 1,2,3, up to the amount of words there are in the text
  // and those numbers follow the  Strings in the string array so it knows where
  // the string was found
  static void merge(String[] A, int[] lineNumber, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;
    String[] L = new String[n1];
    String[] R = new String[n2];
    int[] Lsub = new int[n1];
    int[] Rsub = new int[n2];
    int i, j, k;

    for (i = 0; i < n1; i++) {
      L[i] = A[p + i];
      Lsub[i] = lineNumber[p + i];
    }
    for (j = 0; j < n2; j++) {
      R[j] = A[q + j + 1];
      Rsub[j] = lineNumber[q + j + 1];
    }
    i = 0;
    j = 0;
    for (k = p; k <= r; k++) {
      if (i < n1 && j < n2) {
        if (L[i].compareTo(R[j]) < 0) {
          A[k] = L[i];
          lineNumber[k] = Lsub[i];
          i++;
        } else {
          A[k] = R[j];
          lineNumber[k] = Rsub[j];
          j++;
        }
      } else if (i < n1) {
        A[k] = L[i];
        lineNumber[k] = Lsub[i];
        i++;
      } else {
        A[k] = R[j];
        lineNumber[k] = Rsub[j];
        j++;
      }
    }
  }
  // this mergeSort function basically splits the array into sub arrays until it
  // is size 1 then this goes to merge which compares all the values in the sub
  // array
  static void mergeSort(String[] A, int[] lineNumber, int p, int r) {
    int q;
    if (p < r) {
      q = (p + r) / 2;
      // System.out.println(p+" "+q+" "+r);
      mergeSort(A, lineNumber, p, q);
      mergeSort(A, lineNumber, q + 1, r);
      merge(A, lineNumber, p, q, r);
    }
  }
  // This binarySearch requires the array to be in order and finds a target
  // within that array and outputs it. If not found it will output a -1
  static String binarySearch(String[] A, int[] lineNumber, int p, int r,
                             String target) {
    int q;
    if (p > r) {
      return " not found.";
    } else {
      q = (p + r) / 2;
      if (target.compareTo(A[q]) == 0) {
        return " found on line " + lineNumber[q];
      } else if (target.compareTo(A[q]) < 0) {
        return binarySearch(A, lineNumber, p, q - 1, target);
      } else { // target > A[q]
        return binarySearch(A, lineNumber, q + 1, r, target);
      }
    }
  }
}
