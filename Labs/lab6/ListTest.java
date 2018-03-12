//-------------------------------------------------
//ListTest.java
//Wilson Au-Yeung
//wwauyeun
//May 24,2016
//CMPS12M
//A test client for the List ADT but allows me to check every function
//step by step
//-------------------------------------------------

public class ListTest{
        public static void main(String[] args){
                List<String> A = new List<String>();
                List<String> B = new List<String>();
                B.add(1,"Teamplayer");
                A.add(1,"Teamplayer");
                A.add(2,"Teamplayer2");
                System.out.println("A: " +A);
                System.out.println(A.equals(A));
                B.add(2,"Teamplayer2");
                System.out.println(A.equals(B));
                System.out.println(A.size());
                System.out.println("A.get(2) is "+A.get(2));
                A.remove(1);
                System.out.println("A: " +A);
        }
}

