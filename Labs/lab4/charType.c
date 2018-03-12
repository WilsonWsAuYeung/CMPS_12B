//-----------------------------------------------------------------------------
// charType.c
// Wilson Au-Yeung
// wwauyeun
// CMPS12M
// Lab 4
// April 29,2016
// This C program allows me to take in an in file and a out file and takes all
// the characters and seperate them into 4 different categories. ie
// alphabetical, numeric, punctuation, and whitespace characters. It lists the
// characters of each category and shows how many of a single kind of character
// are there. In order for us to be able to list them, we had to create char
// arrays for each individual category. We had to use calloc in order for us to
// allocate memory for each indivual category. And lastly, to let the code
// determine what is in each category, we had to use built in functions from
// ctype.h (isalnum(), isalpha(), isdigit(), ispunct(), and isspace() )
//-----------------------------------------------------------------------------

#include <assert.h>
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_STRING_LENGTH 100

// function prototype
void extract_chars(char *s, char *a, char *d, char *p, char *w);

// function main which takes command line arguments
int main(int argc, char *argv[]) {
  FILE *in;  // handle for input file
  FILE *out; // handle for output file
  char *s;   // string holding input line
  char *a;   // string holding all alphabetical stuff
  char *d;   // string holding all digits
  char *p;   // string holding all punctuation
  char *w;   // string holding all whitespace
  int lineCount = 1;
  // check command line for correct number of arguments
  if (argc != 3) {
    printf("Usage: %s input-file output-file\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  // open input file for reading
  if ((in = fopen(argv[1], "r")) == NULL) {
    printf("Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }

  // open output file for writing
  if ((out = fopen(argv[2], "w")) == NULL) {
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);
  }

  // allocate strings s, a, d, p, w on the heap
  s = calloc(MAX_STRING_LENGTH + 1, sizeof(char));
  a = calloc(MAX_STRING_LENGTH + 1, sizeof(char));
  d = calloc(MAX_STRING_LENGTH + 1, sizeof(char));
  p = calloc(MAX_STRING_LENGTH + 1, sizeof(char));
  w = calloc(MAX_STRING_LENGTH + 1, sizeof(char));
  assert(s != NULL && a != NULL && d != NULL && p != NULL && w != NULL);

  // read each line in input line
  while (fgets(s, MAX_STRING_LENGTH, in) != NULL) {
    // calls on the function extrac_chars to seperate into seperate
    // strings / char arrays
    extract_chars(s, a, d, p, w);
    // creating variables to hold size of each char array
    int La = strlen(a);
    int Ld = strlen(d);
    int Lp = strlen(p);
    int Lw = strlen(w);
    // prints out the char array in a better format
    fprintf(out, "line %d contains:\n", lineCount);
    if (strlen(a) == 1)
      fprintf(out, "%d alphabetic character: %s\n", La, a);
    else
      fprintf(out, "%d alphabetic characters: %s\n", La, a);
    if (strlen(d) == 1)
      fprintf(out, "%d numeric character: %s\n", Ld, d);
    else
      fprintf(out, "%d numeric characters: %s\n", Ld, d);
    if (strlen(p) == 1)
      fprintf(out, "%d punctuation character: %s\n", Lp, p);
    else
      fprintf(out, "%d punctuation characters: %s\n", Lp, p);
    if (strlen(w) == 1)
      fprintf(out, "%d whitespace character: %s\n", Lw, w);
    else
      fprintf(out, "%d whitespace characters: %s\n", Lw, w);
    lineCount++;
  }

  // free heap memory
  free(s);
  free(a);
  free(d);
  free(p);
  free(w);

  // close input and output files
  fclose(in);
  fclose(out);

  return EXIT_SUCCESS;
}

// function definition
void extract_chars(char *s, char *a, char *d, char *p, char *w) {
  // Counters for each string so it knows where to store each char
  int stringCounter = 0;
  int aC = 0;
  int dC = 0;
  int pC = 0;
  int wC = 0;
  // as long as it did not go through the whole initial input string
  // and as long as it did not go past the Max String amount
  while (s[stringCounter] != '\0' && stringCounter < MAX_STRING_LENGTH) {
    if (isalpha((int)s[stringCounter])) {
      a[aC++] = s[stringCounter];
    } else if (isdigit((int)s[stringCounter])) {
      d[dC++] = s[stringCounter];
    } else if (ispunct((int)s[stringCounter])) {
      p[pC++] = s[stringCounter];
    } else if (isspace((int)s[stringCounter])) {
      w[wC++] = s[stringCounter];
    }
    stringCounter++;
  }
  // ends each char array
  a[aC] = '\0';
  d[dC] = '\0';
  p[pC] = '\0';
  w[wC] = '\0';
}
