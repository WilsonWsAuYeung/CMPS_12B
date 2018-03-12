//---------------------------------------------------------------
// Dictionary.java
// Wilson Au-Yeung
// wwauyeun
// April 21,2016
// CMPS12B
// This file basically creates and defines the Dictionary class that we would
// use to implement the interface.
//--------------------------------------------------------------
public class Dictionary implements DictionaryInterface {
  private class Node {
    String index;
    String newItem;
    Node next;

    Node(String index, String newItem) {
      this.index = index;
      this.newItem = newItem;
      next = null;
    }
  }
  private Node head;
  private int numItems;
  // creates Dictionary which is empty and sets head to null initially
  public Dictionary() {
    head = null;
    numItems = 0;
  }
  // checks if the number if items in it is empty
  public boolean isEmpty() {
    if (numItems == 0)
      return true;
    return false;
  }
  // returns the size
  public int size() { return numItems; }
  // able to insert a pair into dictionary
  public void insert(String index, String newItem)
      throws DuplicateKeyException {
    if (lookup(index) != null)
      throw new DuplicateKeyException("Cannot insert duplicate key");
    else {
      if (head == null) {
        Node temp = new Node(index, newItem);
        head = temp;
        numItems++;
      } else {
        Node temp = head;
        while (temp != null) {
          if (temp.next == null) {
            break;
          }
          temp = temp.next;
        }
        temp.next = new Node(index, newItem);
        numItems++;
      }
    }
  }
  // allows us to look up if target pair is inside the dictionary wherever it is
  public String lookup(String index) {
    Node temp;
    for (temp = head; temp != null; temp = temp.next) {
      if (temp.index.equals(index))
        return temp.newItem;
    }
    return null;
  }
  // resets the whole thing and initializes head to null and numItems to zero
  public void makeEmpty() {
    head = null;
    numItems = 0;
  }
  // looks up if a target pair is in Dictionary and removes it if it is
  public void delete(String index)throws KeyNotFoundException {
    if (lookup(index) == null)
      throw new KeyNotFoundException("Cannot delete non-existent key");
    else {
      if (numItems <= 1) {
        Node temp = head;
        head = head.next;
        temp.next = null;
        numItems--;
      } else {
        Node temp = head;
        if (temp.index.equals(index)) {
          head = temp.next;
          numItems--;
        } else {
          while (!temp.next.index.equals(index)) {
            temp = temp.next;
          }
          temp.next = temp.next.next;
          numItems--;
        }
      }
    }
  }
  public String toString() {
    Node temp = head;
    String pairs = "";
    while (temp != null) {
      pairs += temp.index + " " + temp.newItem + "\n";
      temp = temp.next;
    }
    return pairs;
  }
}
