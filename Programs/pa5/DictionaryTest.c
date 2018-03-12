// Wilson Au-Yeung
// wwauyeun
// CMPS12b
// May 29,2016
// DictionaryTest.c
// Tests Dictionary.c step by step
#include "Dictionary.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN 180

int main(int argc, char *argv[]) {
  Dictionary A = newDictionary();
  char *k;
  char *v;
  char *word1[] = {"one", "two", "three", "four", "five", "six", "seven"};
  char *word2[] = {"1", "2", "3", "4", "5", "6", "7"};
  int i;

  for (i = 0; i < 7; i++) {
    insert(A, word1[i], word2[i]);
  }
  printDictionary(stdout, A);

  delete (A, "one");
  delete (A, "three");
  delete (A, "seven");
  printDictionary(stdout, A);
  makeEmpty(A);
  freeDictionary(&A);
  printDictionary(stdout, A);
}
