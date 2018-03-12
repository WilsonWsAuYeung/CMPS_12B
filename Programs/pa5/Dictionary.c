// Wilson Au-Yeung
// wwauyeun
// CMPS12B
// May 29,2016
// Dictionary.c
// This is another variation of the Dictionary ADT using hash tables in C
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// including header files
#include "Dictionary.h"
// setting global variables
const int tableSize = 101;

unsigned int rotate_left(unsigned int value, int shift) {
  int sizeInBits = 8 * sizeof(unsigned int);
  shift = shift & (sizeInBits - 1);
  if (shift == 0)
    return value;
  return (value << shift) | (value >> (sizeInBits - shift));
}

unsigned int pre_hash(char *input) {
  unsigned int result = 0xBAE86554;
  while (*input) {
    result ^= *input++;
    result = rotate_left(result, 5);
  }
  return result;
}

int hash(char *key) { return pre_hash(key) % tableSize; }

typedef struct NodeObj {
  char *key;
  char *value;
  struct NodeObj *next;
} NodeObj;

typedef NodeObj *Node;

Node newNode(char *k, char *v) {
  Node N = malloc(sizeof(NodeObj));
  assert(N != NULL);
  N->key = k;
  N->value = v;
  N->next = NULL;
  return (N);
}

void freeNode(Node *pN) {
  if (pN != NULL) {
    if (*pN != NULL) {
      free(*pN);
      *pN = NULL;
    }
  }
}

typedef struct ListObj {
  Node head;
} ListObj;

typedef ListObj *List;

List newList(void) {
  List L = malloc(sizeof(ListObj));
  assert(L != NULL);
  L->head = NULL;
  return L;
}
// Dictionary
// Exported reference type
typedef struct DictionaryObj {
  List table;
  int numItems;
} DictionaryObj;

Node findKey(Node head, char *key) {
  if (head == NULL || strcmp(key, head->key) == 0) {
    return head;
  } else {
    return findKey(head->next, key);
  }
}

void deleteFree(Node N) {
  if (N != NULL) {
    deleteFree(N->next);
    freeNode(&N);
  }
}
// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void) {
  Dictionary D = malloc(sizeof(DictionaryObj));
  assert(D != NULL);
  D->table = calloc(tableSize, sizeof(ListObj));
  D->numItems = 0;
  return D;
}
// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary *pD) {
  if (pD != NULL && *pD != NULL) {
    if (!isEmpty(*pD))
      makeEmpty(*pD);
    free(*pD);
    *pD = NULL;
  }
}
// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D) {
  if (D == NULL) {
    fprintf(stderr, "Dictionary Error: calling isEmpty() on invalid Dictionary "
                    "reference\n");
    exit(EXIT_FAILURE);
  }
  return (D->numItems == 0);
}
// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary Dictionary) {
  if (Dictionary == NULL) {
    fprintf(stderr, "Dictionary Error: null reference\n");
    exit(EXIT_FAILURE);
  } else {
    // Counter
    return (Dictionary->numItems);
  }
}
// lookup()
// such value v exists.
// pre: none
char *lookup(Dictionary D, char *k) {
  int tabLoc;
  Node N;
  List L;
  tabLoc = hash(k);
  L = &D->table[tabLoc];
  N = findKey(L->head, k);
  if (N == NULL) {
    return NULL;
  } else {
    return N->value;
  }
}
// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary D, char *k, char *v) {
  Node N;
  List L;
  int tabLoc = hash(k);
  N = newNode(k, v);
  L = &D->table[tabLoc];
  if (findKey(L->head, k) != NULL) {
    fprintf(stderr, "Dictionary Error: calling insert() on existing key\n");
    exit(EXIT_FAILURE);
  }
  N->next = L->head;
  L->head = N;
  N = NULL;
  D->numItems++;
}
// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete (Dictionary D, char *k) {
  if (D == NULL) {
    fprintf(stderr, "Dictionary Error: calling delete() on NULL reference\n");
    exit(EXIT_FAILURE);
  }
  Node N;
  List L;
  int tabLoc;
  tabLoc = hash(k);
  L = &D->table[tabLoc];
  if (findKey(L->head, k) == L->head) {
    N = L->head;
    L->head = L->head->next;
    N->next = NULL;
  } else {
    N = findKey(L->head, k);
    Node prev = L->head;
    Node temp = L->head->next;
    while (temp != N) {
      temp = temp->next;
      prev = prev->next;
    }
    prev->next = N->next;
    N->next = NULL;
  }
  D->numItems--;
  freeNode(&N);
}
// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D) {
  List L;
  if (D == NULL) {
    fprintf(stderr,
            "Dictionary Error: calling makeEmpty() on NULL reference\n");
    exit(EXIT_FAILURE);
  }
  if (D->numItems == 0) {
    fprintf(stderr,
            "Dictionary Error: calling makeEmpty() on an empty Dictionary\n");
    exit(EXIT_FAILURE);
  }
  for (int i = 0; i < tableSize; i++) {
    L = &D->table[i];
    deleteFree(L->head);
  }
  D->table = NULL;
  D->numItems = 0;
}
// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE *out, Dictionary D) {
  if (D == NULL) {
    fprintf(stderr,
            "Dictionary Error: calling printDictionary() on NULL reference\n");
    exit(EXIT_FAILURE);
  }
  List L;
  Node N;
  for (int i = 0; i < tableSize; i++) {
    L = &D->table[i];
    N = L->head;
    while (N != NULL) {
      fprintf(out, "%s %s\n", N->key, N->value);
      N = N->next;
    }
  }
}
