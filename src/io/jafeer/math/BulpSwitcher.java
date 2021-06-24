package io.jafeer.math;

import java.util.Arrays;

public class BulpSwitcher {
public static void main(String[] args)
{
    System.out.println(bulbSwitch(3));
}
    public static  int bulbSwitch(int n) {
        Boolean[] array = new Boolean[n];
        Arrays.fill(array, true);
        for (int i = 2; i <= n; i++) {
            for (int j = i; j < n; j = j + i)
                array[j] = !array[j];
            printArray(array);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i])
                count++;
        }
        return count;
    }
public static void printArray(Boolean[] arr)
{
    for(Boolean no:arr)
System.out.print("\t"+no);
    System.out.println();
}
}
