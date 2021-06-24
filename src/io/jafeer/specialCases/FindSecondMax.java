package io.jafeer.specialCases;

public class FindSecondMax {
  public static void main(String[] args)
  {
      int[] nos={3,6,2,1,4};
      int max=Integer.MIN_VALUE;
      int secondMax=Integer.MIN_VALUE;
      for(int no:nos) {
          if (max < no) {
              secondMax = max;
              max = no;

          }
      }
      System.out.println("Max:"+max+"\tSecond max:"+secondMax);
  }

}
