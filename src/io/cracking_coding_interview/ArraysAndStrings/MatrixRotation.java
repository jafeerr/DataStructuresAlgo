package io.cracking_coding_interview.ArraysAndStrings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MatrixRotation {
    static void matrixRotation(int[][] matrix,int r) {
        int startIndex = 0, endRowIndex = matrix.length - 1, endColumnIndex = matrix[0].length - 1;
        int[][] result = new int[endRowIndex+1][endColumnIndex+1];
        traverse(matrix,result,startIndex,endRowIndex,endColumnIndex,r);

    }
    public static void traverse(int[][] matrix, int result[][], int startIndex, int endRowIndex, int endColumnIndex,int r) {
        int i = startIndex, j = startIndex;
        for (; i < endRowIndex; i++) {
            result[i + 1][j] = matrix[i][j];
        }
        for (; j < endColumnIndex; j++) {
            result[i][j + 1] = matrix[i][j];
        }
        for (; i > startIndex; i--) {
            result[i - 1][j] = matrix[i][j];
        }
        for (; j > startIndex; j--) {
            result[i][j - 1] = matrix[i][j];
        }

        if (startIndex < endRowIndex-1 && startIndex < endColumnIndex-1)
            traverse(matrix, result, startIndex + 1, endRowIndex - 1, endColumnIndex - 1,r);
        else {
            if(r>1)
            {
                traverse(result, new int[matrix.length][matrix[0].length], 0, matrix.length - 1, matrix[0].length - 1,r-1);
            }
            else{
                for (int x = 0; x < result.length; x++) {
                    for (int y = 0; y <result[i].length; y++)
                        System.out.print((y==0?"":" " )+ result[x][y]);
                    if(x<result.length-1)
                        System.out.println();
                }
            }

        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mnr = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        matrixRotation(matrix,r);

        scanner.close();
    }
}

