package io.cracking_coding_interview.common;

public class PrintOut {
    protected static final String EMPTY_STRING="";
    public static void print(String input) {
        System.out.println(input);
    }
    public static void print(char[] input) {
        System.out.println(input);
    }

    public static void printAndExit(String input) {
        print(input);
        System.exit(0);
    }


    public static void printArray(int[] input) {
        StringBuilder builder = new StringBuilder();
        for (int i : input) {
            builder.append(i);
            builder.append(",");
        }
        System.out.println(builder.deleteCharAt(builder.length() - 1).toString());
    }
    public static void printArray(int[][] input) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<input.length;i++) {
            for(int j=0;j<input[i].length;j++)
            {
                System.out.print(input[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void printArray(String[] input) {
        StringBuilder builder = new StringBuilder();
        for (String i : input) {
            builder.append(i);
            builder.append(",");
        }
        System.out.println(builder.deleteCharAt(builder.length() - 1).toString());
    }
}
