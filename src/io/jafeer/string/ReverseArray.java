package io.jafeer.string;

public class ReverseArray {
public static  void main(String[] args)
{
    String input="jafeer@gmail.com";

    System.out.println(ReverseArray.reverseWOSpclChar(input.toCharArray()));
}
    public static char[] reverseWOSpclChar(char[] input) {
int startIndex=0,endIndex=input.length-1;

      while (startIndex<endIndex)
      {
          if(isAlphapet(input[startIndex]) && isAlphapet(input[endIndex]))
          {
              char temp=input[startIndex];
              input[startIndex]=input[endIndex];
              input[endIndex]=temp;
              startIndex++;
              endIndex--;
          }
          else if(isAlphapet(input[startIndex]))
              endIndex--;
          else
              startIndex++;
      }
      return input;
    }
    private static boolean  isAlphapet(char a)
    {
        return a>='A' && a<='z';
    }
}
