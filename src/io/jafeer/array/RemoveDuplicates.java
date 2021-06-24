package io.jafeer.array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args)
    {
        int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20};
//System.out.println(findMissingNumberInSequentialArray(array));
        int[] result= removeDuplicates(new int[]{10,8,10,7,8});

        for(int no:result)
            System.out.print("\t"+no);

       }
    public static int findMissingNumberInSequentialArray(int[] a){
        int xorCalulated = 1;
        for(int i=2;i<=a.length;i++)// this loop runs (n) times
        {
            int temp=xorCalulated;
            xorCalulated ^= i;
            System.out.println(temp+" ^ "+i+" = "+xorCalulated);
        }

        int xorActual=a[0];
        for(int i=1;i<(a.length-1);i++) // this loop runs (n-1) times. Since there is one element "missing"
            xorActual^=a[i];

        System.out.println("Calc:"+xorCalulated+"\tActual:"+xorActual);
        return xorActual^xorCalulated;

    }
   public static int[] removeDuplicates(int[] array){
        int index=0,duplicateCount=0;
        for(int i=0;i<array.length;i++)
        {
            int j;
            for(j=0;j<i;j++) {
                System.out.println("i:"+i+" j:"+j+"\ta[i]:"+array[i]+"\ta[j]:"+array[j]);
                if (array[i] == array[j]) {
                    duplicateCount++;
                    break;
                }
            }
            System.out.println("i:"+i+" j:"+j);
          if(i==j)
              array[index++]=array[i];
        }
        return Arrays.copyOf(array,array.length-duplicateCount);
   }
    }
