//-----------------------------------------------------------------------------
// Recursion.java
// Wilson Au-Yeung
// wwauyeun
// CMPS12B
// April 4,2015
// Using the concept of recursion, we were told to copy the elements of the
// given array, and paste it in reverse order into a second array. We had to do
// this same action using three different methods. The second task we were told
// to do is to print out the location of the minimum and maximum value of an
// element in the array. There was a lot of ways to compare different values of
// elements in an array, but we were told to use the concept of merge sort which
// says to divide the array by 2 and keep doing that till the sub-array was of
// size one and compare those values and build them back together.
//-----------------------------------------------------------------------------

class Recursion {

  // reverseArray1()
  // Places the leftmost n elements of X[] into the rightmost n positions in
  // Y[] in reverse order
  static void reverseArray1(int[] X, int n, int[] Y) {
    if (n > 0) {
      Y[n - 1] = X[X.length - n];
      reverseArray1(X, n - 1, Y);
    }
  }

  // reverseArray2()
  // Places the rightmost n elements of X[] into the leftmost n positions in
  // Y[] in reverse order.
  static void reverseArray2(int[] X, int n, int[] Y) {
    if (n > 0) {
      Y[X.length - n] = X[n - 1];
      reverseArray2(X, n - 1, Y);
    }
  }

  // reverseArray3()
  // Reverses the subarray X[i...j].
  static void reverseArray3(int[] X, int i, int j) {
    if (j > i) {
      int temp = X[j];
      X[j] = X[i];
      X[i] = temp;
      reverseArray3(X, i + 1, j - 1);
    }
  }

  // maxArrayIndex()
  // returns the index of the largest value in int array X
  static int maxArrayIndex(int[] X, int p, int r) {
    int left;
    int right;
    int higher;
    boolean lowhigh = false;
    if (p < r) {
      int q = (p + r) / 2;
      left = maxArrayIndex(X, p, q);
      right = maxArrayIndex(X, q + 1, r);
      higher = compare(X, left, right, lowhigh);
      return higher;
    } else {
      return p;
    }
  }

  // minArrayIndex()
  // returns the index of the smallest value in int array X
  static int minArrayIndex(int[] X, int p, int r) {
    int left;
    int right;
    int lower;
    boolean lowhigh = true;
    if (p < r) {
      int q = (p + r) / 2;
      left = minArrayIndex(X, p, q);
      right = minArrayIndex(X, q + 1, r);
      lower = compare(X, left, right, lowhigh);
      return lower;
    } else {
      return p;
    }
  }
  // compare()
  // return the higher of the two indexes
  static int compare(int[] X, int right, int left, boolean lowhigh) {
    if (lowhigh == true) {
      if (X[right] <= X[left]) {
        return right;
      } else {
        return left;
      }
    } else if (lowhigh == false) {
      if (X[right] <= X[left]) {
        return left;
      } else {
        return right;
      }
    }
    return 0;
  }
  // main()
  public static void main(String[] args) {

    int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
    int[] B = new int[A.length];
    int[] C = new int[A.length];
    int minIndex = minArrayIndex(A, 0, A.length - 1);
    int maxIndex = maxArrayIndex(A, 0, A.length - 1);

    for (int x : A)
      System.out.print(x + " ");
    System.out.println();

    System.out.println("minIndex = " + minIndex);
    System.out.println("maxIndex = " + maxIndex);

    reverseArray1(A, A.length, B);
    for (int x : B)
      System.out.print(x + " ");
    System.out.println();

    reverseArray2(A, A.length, C);
    for (int x : C)
      System.out.print(x + " ");
    System.out.println();

    reverseArray3(A, 0, A.length - 1);
    for (int x : A)
      System.out.print(x + " ");
    System.out.println();
  }
}
/* Output:
-1 2 6 12 9 2 -5 -2 8 5 7
minIndex = 6
maxIndex = 3
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
*/
