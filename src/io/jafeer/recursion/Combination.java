package io.jafeer.recursion;

public class Combination {
    public static void main(String[] args)
    {
        int[] arr={1,2,3,4,5};
        int combLength=3;
        for(int i=0;i<arr.length-combLength+1;i++)
        {
            printAnagram(arr,arr[i]+"",i,combLength);
        }
    }
    public static void printAnagram(int[] arr,String element,int index,int combLength)
    {
        if(element.length()==combLength)
        {
            System.out.println(element);
        }
        else
        {
            for(int i=index+1;i<arr.length;i++)
            {
                printAnagram(arr,element+arr[i],i,combLength);
            }
        }
    }
}
