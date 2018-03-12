//-----------------------------------------------------------------------------
// QueueEmptyException.java
// Wilson Au-Yeung
// wwauyeun
// May 14,2016
// CMPS12B
// Handles an empty Queue and throws exception
//-----------------------------------------------------------------------------

public class QueueEmptyException extends RuntimeException {
  public QueueEmptyException(String s) { super(s); }
}
