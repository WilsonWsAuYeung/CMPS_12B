//--------------------------------------------------------------
// Dictioanry.java
// Wilson Au-Yeung
// wwauyeun
// May 31,2016
// CMPS12B
// This file is a Binary Search Tree implementation of the Dictionary ADT
//--------------------------------------------------------------
public class Dictionary implements DictionaryInterface {
  // Private Node Class
  private class Node {
    Pair item;
    Node right;
    Node left;
    Node(Pair x) {
      item = x;
      // this.value = value;
      right = null;
      left = null;
    }
  }
  // private Pair Class
  private class Pair {
    String key;
    String value;
    Pair(String a, String b) {
      key = a;
      value = b;
    }
  }

  private Node root;
  private int numPairs;
  // Dictionary constructor
  public Dictionary() {
    root = null;
    numPairs = 0;
  }

  public boolean isEmpty() {
    if (numPairs == 0)
      return true;
    else
      return false;
  }
  public int size() { return numPairs; }
  // returns the parent of N
  private Node findParent(Node N, Node R) {
    Node P = null;
    if (N != R) {
      P = R;
      while (P.left != N && P.right != N) {
        if (N.item.key.compareToIgnoreCase(P.item.key) < 0) {
          P = P.left;
        } else
          P = P.right;
      }
    }
    return P;
  }
  // finds and returns the Node that has a key searched for
  private Node findKey(Node R, String k) {
    if (R == null || R.item.key.equals(k))
      return R;
    else if (R.item.key.compareToIgnoreCase(k) > 0)
      return findKey(R.left, k);
    else
      return findKey(R.right, k);
  }
  // returns the leftmost Node in the subtree
  private Node findLeftmost(Node R) {
    Node L = R;
    for (L = R; L.left != null; L = L.left) {
    }
    return L;
  }
  // inserts a pair into the dictionary adt
  public void insert(String k, String v) throws DuplicateKeyException {
    Node N, A, B;
    if (findKey(root, k) != null) {
      throw new DuplicateKeyException("Cannot insert duplicate key");
    }
    N = new Node(new Pair(k, v));
    B = null;
    A = root;
    while (A != null) {
      B = A;
      if (A.item.key.compareToIgnoreCase(k) > 0)
        A = A.left;
      else
        A = A.right;
    }
    if (B == null)
      root = N;
    else if (B.item.key.compareToIgnoreCase(k) > 0)
      B.left = N;
    else
      B.right = N;
    numPairs++;
  }

  // removes a pair from the dictionary ADT
  public void delete(String key)throws KeyNotFoundException {
    Node N, P, S;
    if (findKey(root, key) == null) {
      throw new KeyNotFoundException(
          "Dictionary Error: delete() cannot delete non-existent key");
    }
    N = findKey(root, key);
    if (N.left == null && N.right == null) {
      if (N == root)
        root = null;
      else {
        P = findParent(N, root);
        if (P.right == N)
          P.right = null;
        else
          P.left = null;
      }
    } else if (N.right == null) {
      if (N == root)
        root = N.left;
      else {
        P = findParent(N, root);
        if (P.right == N)
          P.right = N.left;
        else
          P.left = N.left;
      }
    } else if (N.left == null) {
      if (N == root)
        root = N.right;

      else {
        P = findParent(N, root);
        if (P.right == N)
          P.right = N.right;
        else
          P.left = N.right;
      }
    } else {
      S = findLeftmost(N.right);
      N.item.key = S.item.key;
      N.item.value = S.item.value;
      P = findParent(S, N);
      if (P.right == S)
        P.right = S.right;
      else
        P.left = S.right;
    }
    numPairs--;
  }
  public String lookup(String key) {
    Node N;
    N = findKey(root, key);
    return (N == null ? null : N.item.value);
  }
  public void makeEmpty() {
    deleteAll(root);
    root = null;
    numPairs = 0;
  }
  public String toString() {
    printInOrder(root);
    return "";
  }
  void printInOrder(Node R) {
    if (R != null) {
      printInOrder(R.left);
      System.out.println(R.item.key + " " + R.item.value);
      printInOrder(R.right);
    }
  }
  // deletes all the branches and nodes in the tree
  void deleteAll(Node N) {
    if (N != null) {
      deleteAll(N.left);
      deleteAll(N.right);
    }
  }
}
