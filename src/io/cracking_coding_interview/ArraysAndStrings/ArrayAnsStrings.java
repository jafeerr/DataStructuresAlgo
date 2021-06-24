package io.cracking_coding_interview.ArraysAndStrings;

import io.cracking_coding_interview.common.PrintOut;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAnsStrings extends PrintOut {


    public static void main(String[] args) {
        //1.1
        //checkCharsInStrUnique();

        //1.2
        //checkPermuatation();

        //1.3
        //URLify();


        //1.5
        //oneAway();

        //1.6 String Compression
        //compressString();

        //1.7
        //rotateMatrix();

        //1.8
        //zeroMatrix();

        //1.9
        rotateString();

    }

    //1.1 using hashtable
    public static void checkCharsInStrUnique() {
        String input = "Jafeer";
        boolean[] arr = new boolean[52];
        for (int i = 0; i < input.length(); i++) {
            int position = ((int) input.charAt(i)) % 52;
            if (arr[position]) {
                print("Not unique");
                System.exit(0);
            }

            arr[position] = true;
        }

        print("unique");
    }

    //1.2 using hash table
    public static void checkPermuatation() {
        String input1 = "ajak";
        String input2 = "jaak";

        if (input1.length() == input2.length()) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < input1.length(); i++) {
                sum1 = sum1 + (int) input1.charAt(i);
                sum2 = sum2 + (int) input2.charAt(i);
            }
            if (sum1 == sum2)
                printAndExit("Yes! input2 is permuation of input 1");
        }
        print("No! input2 is permuation of input 1");
    }

    //1.3
    public static void URLify() {
        char[] input = "welcome to possible".toCharArray();
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ')
                count++;

        }
        char[] result = new char[input.length + (count * 2)];
        int resultIndex = result.length;
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                result[--resultIndex] = '0';
                result[--resultIndex] = '2';
                result[--resultIndex] = '%';
            } else
                result[--resultIndex] = input[i];

        }

        print(result);
    }

    //1.4
    public static void oneAway() {
        String str1 = "pale";
        String str2 = "bake";

        int count = 0;

        int str1Index = 0, str2Index = 0;

        while (str1Index < str1.length() && str2Index < str2.length()) {
            if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
                str1Index++;
                str2Index++;
            } else {
                if (++count > 1) {
                    print("Not! OneAway");
                    System.exit(0);
                }
                if (str1.length() == str2.length()) {
                    str1Index++;
                    str2Index++;
                } else if (str1.length() > str2.length()) {
                    str1Index++;
                } else {
                    str2Index++;
                }
            }
        }
        print("Yes! One away");
    }

    //1.5
    public static void compressString() {
        String input = "aabcccccaaa";

        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            if (i + 1 > input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
                builder.append(input.charAt(i));
                builder.append(count);
                count = 0;
            }
        }

        String result = builder.toString();
        if (result.length() < input.length())
            print(result);
        else
            print(input);
    }

    // 1.7
    public static void rotateMatrix() {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printArray(matrix);
        //if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top; // right <- saved top
            }
        }
        printArray(matrix);
    }

    //1.8
    public static void zeroMatrix() {
        int[][] input = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        int[][] result = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 0) {
                    makeRowAndColZeros(result, i, j);
                } else {
                    result[i][j] = input[i][j];
                }
            }
        }
        printArray(result);
    }
    public static void makeRowAndColZeros(int[][] input, int xIndex, int jIndex) {
        for (int i = 0; i < input.length; i++)
            input[i][jIndex] = 0;
        for (int i = 0; i < input[xIndex].length; i++)
            input[xIndex][i] = 0;
    }

    //1.9

    private static void rotateString()
    {
        char[] str1="Jafeer".toCharArray();
        char[] str2="rJaffe".toCharArray();


            for(int j=0;j<str1.length;j++)
            {
                if(str1[j]==str2[0])
                {
                    if(Arrays.equals(str2,rotateString(str1, j)))
                    {
                      print("Yes! ");
                      System.exit(0);
                    }
                }
            }

        print("No!");
    }
    private static char[] rotateString(char[] input, int rotationNo)
    {
        char[] result=new char[input.length];
        for(int i=0;i<input.length;i++)
        {
            result[i]=input[(i+rotationNo)%input.length];
        }
        return result;
    }

}
