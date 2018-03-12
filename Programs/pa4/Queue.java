// Wilson Au-Yeung
// wwauyeun
// May 14,2016
// CMPS12B
// Queue.java
// Described functions prototyped in QueueInterface to create a queue data
// structure
public class Queue implements QueueInterface {

  // private inner Node class
  private class Node {
    Object item;
    Node next;

    Node(Object item) {
      this.item = item;
      next = null;
    }
  }
  private Node front;
  private Node back;
  private int numItems;

  public Queue() {
    front = null;
    back = null;
    numItems = 0;
  }

  public boolean isEmpty() {
    if (numItems == 0)
      return true;
    else
      return false;
  }

  public int length() { return numItems; }

  public void enqueue(Object newItem) {
    if (front == null) {
      front = new Node(newItem);
      numItems++;
    } else {
      Node N = front;
      while (N.next != null) {
        N = N.next;
      }
      N.next = new Node(newItem);
      back = N.next;
      numItems++;
    }
  }
  public Object peek() throws QueueEmptyException {
    if (front == null)
      throw new QueueEmptyException("Usage: using peek() on empty queue stack");
    else {
      Node N = front;
      return N.item;
    }
  }

  public Object dequeue() throws QueueEmptyException {
    if (front == null)
      throw new QueueEmptyException(
          "Usage: using dequeue() on empty queue stack");
    else {
      Node N = front;
      front = N.next;
      numItems--;
      return N.item;
    }
  }

  public void dequeueAll() throws QueueEmptyException {
    if (front == null)
      throw new QueueEmptyException(
          "Usage: using dequeueAll() on empty queue stack");

    front = null;
    back = null;
    numItems = 0;
  }

  public String toString() {
    String str = "";
    Node N = front;
    while (N != null) {
      str += N.item + " ";
      N = N.next;
    }
    return str;
  }
}
