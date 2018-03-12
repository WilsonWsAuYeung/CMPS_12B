//------------------------------------------------------
// Wilson Au-Yeung
// wwauyeun
// CMPS 12B
// April 21, 2016
// If the main function tries to remove a pair that is not in the library, it
// would throw the exception saying "cannot delete non-existent key"
//------------------------------------------------------

public class KeyNotFoundException extends RuntimeException {
  public KeyNotFoundException(String s) { super(s); }
}
