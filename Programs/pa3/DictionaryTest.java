//---------------------------------------------------------------
// DictionaryTest.java
// Wilson Au-Yeung
// wwauyeun
// April 21,2016
// CMPS12B
// This is a client module for testing the Dictionary ADT in isolation. one by
// one so I can check if each function described in DictionaryInterface.java
// works
class DictionaryTest {
  public static void main(String[] args) {
    // Creates new Dictionary
    Dictionary A = new Dictionary();
    // prints out true if it is empty
    System.out.println(A.isEmpty());
    // prints out initial size
    System.out.println(A.size());
    // inserts two pairs
    A.insert("a", "4");
    A.insert("b", "5");
    // checks if it is empty after being inserted into
    System.out.println(A.isEmpty());
    // checks new size
    System.out.println(A.size());
    // sees if the index is in it
    System.out.println(A.lookup("b"));
    System.out.println(A.lookup("a"));
    // completely emptys it out
    A.makeEmpty();
    // inserts new pair
    A.insert("c", "3");
    A.insert("d", "6");
    // looks up "c" and "a"
    System.out.println(A.lookup("c"));
    System.out.println(A.lookup("a"));
    // deletes the d pair
    A.delete("d");
    // looks up "d"
    System.out.println(A.lookup("d"));
    // again checks the size
    System.out.println(A.size());
    A.delete("c");
    A.makeEmpty();
    A.insert("a", "1");
    A.insert("b", "2");
    A.insert("c", "3");
    A.insert("d", "4");
    System.out.println(A.lookup("a"));
    System.out.println(A.lookup("b"));
    System.out.println(A.lookup("c"));
    System.out.println(A.lookup("d"));
    System.out.println(A);
  }
}
