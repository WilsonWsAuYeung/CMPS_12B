//-------------------------------------------------
// DictionaryTest.c
// Wilson Au-Yeung
// wwauyeun
// May 6,2016
// CMPS12m
// Testing client for Dictionary ADT step by step
//-------------------------------------------------

#include "Dictionary.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LEN 180

int main(int argc, char *argv[]) {
  Dictionary A = newDictionary();
  char *a;
  char *b;
  char *word1[] = {"one", "two", "three"};
  char *word2[] = {"TEAMPLAYER", "TEAMPLAYER2", "TEAMPLAYER3"};
  int num;
  insert(A, word1[0], word2[0]);
  insert(A, word1[1], word2[1]);
  insert(A, word1[2], word2[2]);
  printDictionary(stdout, A);
  delete (A, "two");
  printf("\n");
  printDictionary(stdout, A);
  printf(lookup(A, "three"));
  // printf("\n");
  makeEmpty(A);
  printDictionary(stdout, A);
}
