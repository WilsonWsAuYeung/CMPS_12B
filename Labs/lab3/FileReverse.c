//-----------------------------------------------------------------------------
// FileReverse.c
// Wilson Au-Yeung
// wwauyeun
// April 17,2016
// CMPS12M
// Reads input file and prints each word in reverse on a separate line of
// the output file. Does not use recursion but it used a loop that basically
// swaps the first and last letter and then inner. Learned how to implement
// FileReverse.java in C instead of java
//-----------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void FileReverse(char *s);
int main(int argc, char *argv[]) {
  FILE *in, *out; // handles for input and output files
  char word[256]; // char array to store words from input file
  int wordsNum = 0;
  // check command line for correct number of arguments
  if (argc != 3) {
    printf("Usage: %s <input file> <output file>\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  // open input file for reading
  in = fopen(argv[1], "r");
  if (in == NULL) {
    printf("Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }

  // open output file for writing
  out = fopen(argv[2], "w");
  if (out == NULL) {
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);
  }
  //  printf("%s contains %d characters\n", argv[1], strlen(argv[1]) );
  // read words from input file, print on separate lines to output file
  while (fscanf(in, " %s", word) != EOF) {
    // fprintf(out, "%s\n", word);
    stringReverse(word);
    fprintf(out, "%s\n", word);
    // wordsNum = wordsNum+1;
  }
  // testing array
  // int i = 0;
  // for(i=0;i < wordsNum-1;i++)
  // printf("%s\n ",word);
  // close input and output files
  fclose(in);
  fclose(out);

  return (EXIT_SUCCESS);
}
// stringReverse basically takes in a string and swaps the first and last
// letters of it. then it swaps the inner letters until both pointers they meet
// or the first pointer is greater than the second pointer

void stringReverse(char *s) {
  int i = 0;
  int j = strlen(s) - 1;
  char temp;
  while (i < j) {
    temp = s[i];
    s[i] = s[j];
    s[j] = temp;
    i++;
    j--;
  }
}
