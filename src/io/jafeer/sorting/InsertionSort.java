package io.jafeer.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {4,5,6,1,2,3};

        for (int i = 1; i < array.length; i++) {
            int key=array[i];
            int j = i - 1;

            while (j >= 0 && array[j]>key) {
                    array[j+1] = array[j];
                j--;
            }
            array[j+1]=key;
            for (int k = 0; k < array.length; k++)
                System.out.print("\t" + array[k]);
            System.out.println();
        }

        for (int i = 0; i < array.length; i++)
            System.out.print("\t" + array[i]);

    }

    public static void insertionSort(){
        int[] a={6,5,4,3,1,2};

    }
}
