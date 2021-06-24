package io.jafeer.matrix;

import java.util.Arrays;
import java.util.Calendar;

public class ZigZagConversion {
    public static void main(String[] args) {
        for(int i=12;i<13;i++)
        {
            long start=Calendar.getInstance().getTimeInMillis();
            System.out.println(ZigZagConversion.convert("PAYPALISHIRING",i));
            System.out.println(Calendar.getInstance().getTimeInMillis()-start+"ms");

        }



    }

    public static int getColumnNo(Integer strLength, Integer noOfRows) {
        int median = noOfRows>3?noOfRows-2:0;
        int slot = (int) Math.ceil(strLength.doubleValue() / (noOfRows + median));
        int slotStartValue = (((slot - 1) * (noOfRows - 1)) + 1);
        int temp = (strLength % (noOfRows + median));
        return (int) (temp <= noOfRows && temp != 0 ? slotStartValue : slotStartValue + ((temp == 0) ? median : (temp - noOfRows)));

    }

    public static String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        long start=Calendar.getInstance().getTimeInMillis();
        int numCols = getColumnNo(s.length(), numRows);
        Character[][] result = new Character[numRows][numCols];
        for(int i=0;i<numRows;i++)
            for(int j=0;j<numCols;j++)
                result[i][j]=Character.MIN_VALUE;
        int xIndex = -1, yIndex = 0, stringPointer = 0;

        while (stringPointer <= s.length() - 1) {

            while (xIndex < numRows - 1 && stringPointer <= s.length() - 1) {
                result[++xIndex][yIndex] = s.charAt(stringPointer++);
            }

            while (xIndex > 0  && yIndex <(numCols-1) && stringPointer <= s.length() - 1) {

                result[--xIndex][++yIndex] = s.charAt(stringPointer++);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if(result[i][j]!=Character.MIN_VALUE)
                builder.append(result[i][j]);
            }
        }
        return builder.toString();
    }

}

