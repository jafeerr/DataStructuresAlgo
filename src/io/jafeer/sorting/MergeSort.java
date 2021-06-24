package io.jafeer.sorting;


import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {6, 5, 4, 3, 2, 1};
        MergeSort object = new MergeSort(numbers);
        object.sort();
        object.printArray();
    }

    int[] numbers;

    public MergeSort(int[] nos) {
        numbers = nos;
    }

    public void sort() {
        sort(0, numbers.length - 1);
    }

    private void sort(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(start, middle);
            sort(middle + 1, end);

            merge(start, middle, end);
        }
    }

    private void merge(int start, int middle, int end) {
        int[] temp1 = Arrays.copyOfRange(numbers, start, middle+1);
        int[] temp2 = Arrays.copyOfRange(numbers, middle + 1, end+1);
        int i = 0, j = 0, k = start;
        while (i < temp1.length && j < temp2.length) {
            if (temp1[i] <= temp2[j])
                numbers[k++] = temp1[i++];
            else
                numbers[k++] = temp2[j++];

        }
        while(i < temp1.length)
            numbers[k++] = temp1[i++];
        while(j < temp2.length)
            numbers[k++] = temp2[j++];
    }

    private void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; ++i)
            System.out.print(numbers[i] + " ");
        System.out.println();
    }

    public void printArray()
    {
        printArray(numbers);
    }
}


