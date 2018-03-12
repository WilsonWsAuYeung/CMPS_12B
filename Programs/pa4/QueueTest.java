// Wilson Au-Yeung
// wwauyeun
// May 14,2016
// CMPS12B
// QueueTest Tests our ADT one function at a time;
public class QueueTest {
  public static void main(String[] args) {
    Queue Test = new Queue();
    Test.enqueue((int)1);
    System.out.println(Test.isEmpty());
    Test.enqueue((int)2);
    Test.enqueue((int)3);
    System.out.println(Test.length());
    System.out.println(Test.isEmpty());
    System.out.println(Test.peek());
    Test.dequeue();
    System.out.println(Test);
    Test.dequeueAll();
    System.out.println(Test);
  }
}
