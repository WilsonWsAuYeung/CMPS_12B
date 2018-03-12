//------------------------------------------------
// Wilson Au-Yeung
// wwauyeun
// May 6,2016
// CMPS12B
// Dictionary.c
// Linked List implementation of the Dictionary.ADT.
//------------------------------------------------
#include "Dictionary.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// NodeObj
typedef struct NodeObj {
  struct NodeObj *next;
  char *key;
  char *value;
} NodeObj;

// Node
typedef NodeObj *Node;

// newNode()
// constructor for private Node Type
Node newNode(char *k, char *v) {
  Node N = malloc(sizeof(NodeObj));
  assert(N != NULL);
  N->key = k;
  N->value = v;
  N->next = NULL;
  return (N);
}
void freeNode(Node *pN) {
  if (pN != NULL && *pN != NULL) {
    free(*pN);
    *pN = NULL;
  }
}
struct DictionaryObj {
  Node Head;
  Node Tail;
  int numPairs;
} DictionaryObj;
// Constructor for the new Dictionary Type
Dictionary newDictionary(void) {
  Dictionary D = malloc(sizeof(Dictionary));
  assert(D != NULL);
  D->Head = NULL;
  D->Tail = NULL;
  D->numPairs = 0;
  return D;
}
// destructor for the Dictionary
void freeDictionary(Dictionary *pD) {
  if (pD != NULL && *pD != NULL) {
    makeEmpty(*pD);
    free(*pD);
    *pD = NULL;
  }
}
// it checks if the Dictionary type is empty. Returns 1 if it is, and if not
// returns 0
int isEmpty(Dictionary D) {
  if (D == NULL) {
    fprintf(
        stderr,
        "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
    exit(EXIT_FAILURE);
  }
  if (D->numPairs == 0) {
    return 1;
  } else
    return 0;
}
// the numPairs in the Dictionary Type keeps track of how many pairs are in D
int size(Dictionary D) {
  if (D == NULL) {
    fprintf(stderr,
            "Dictionary Error: calling size() on NULL Dictionary reference\n");
    exit(EXIT_FAILURE);
  }
  return D->numPairs;
}
// allows me to insert a new key that goes with a value into the Dictionary.
void insert(Dictionary D, char *k, char *v) {
  if (D == NULL) {
    fprintf(
        stderr,
        "Dictionary Error: calling insert() on NULL Dictionary reference\n");
    exit(EXIT_FAILURE);
  }
  if (lookup(D, k) != NULL) {
    fprintf(stderr, "Dictionary Error: calling insert() duplicate keys\n");
    exit(EXIT_FAILURE);
  }
  if (D->numPairs == 0) {
    D->Head = D->Tail = newNode(k, v);
  } else {
    Node N = newNode(k, v);
    D->Tail->next = N;
    D->Tail = N;
  }
  D->numPairs++;
}
// this helps me check if there are duplicates of a key or if there are any of
// the keys at all used by insert() and delete()
char *lookup(Dictionary D, char *k) {
  Node N = D->Head;
  if (D == NULL) {
    fprintf(stderr, "Dictionary Error: calling lookup()  on NULL Dictionary\n");
    exit(EXIT_FAILURE);
  }
  for (N; N != NULL; N = N->next) {
    if (strcmp(N->key, k) == 0)
      return N->value;
  }
  return NULL;
}
// empties the Dictionary to NULL
void makeEmpty(Dictionary D) {
  D->Head = NULL;
  D->Tail = NULL;
  D->numPairs = 0;
}
// deletes a key and its value in a dictionary
void delete (Dictionary D, char *k) {
  Node N = D->Head;
  if (lookup(D, k) == NULL) {
    fprintf(stderr, "Dictionary error: key not found\n");
    exit(EXIT_FAILURE);
  }
  if (strcmp(N->key, k) == 0) {
    Node Temp = D->Head;
    Node non = Temp->next;
    D->Head = non;
    freeNode(&Temp);
  } else {
    while (N != NULL && N->next != NULL) {
      if (strcmp(N->next->key, k) == 0) {
        Node non = N;
        Node non2 = N->next;
        non->next = non2->next;
        N = non;
        freeNode(&non2);
      }
      N = N->next;
    }
  }
  D->numPairs--;
}

// prints out the Dictionary
void printDictionary(FILE *out, Dictionary D) {
  Node N;
  if (D == NULL) {
    fprintf(stderr, "Dictionary Error: calling printDictionary() on NULL "
                    "Dictionary reference\n");
    exit(EXIT_FAILURE);
  }
  for (N = D->Head; N != NULL; N = N->next)
    fprintf(out, "%s %s \n", N->key, N->value);
  fprintf(out, "\n");
}
