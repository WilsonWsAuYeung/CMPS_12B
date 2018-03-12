//------------------------------------------------------
// Wilson Au-Yeung
// wwauyeun
// CMPS 12B
// April 21, 2016
// If it inserts a duplicate key, it would throw the exception saying "cannot
// insert duplicate keys"
//------------------------------------------------------

public class DuplicateKeyException extends RuntimeException {
  public DuplicateKeyException(String s) { super(s); }
}
