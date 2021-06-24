package io.jafeer.specialCases;

public class DivisionWithoutOper {
    public static void main(String[] args)
    {
int result=DivisionWithoutOper.divide(2147483647,
        1);
System.out.println(result);
    }
    public static int divide(int dividend, int divisor) {
        int count=0;
        boolean toProceed=true;
        int temp=dividend;
        while(toProceed)
        {
            if((dividend>0 && divisor>0) || (dividend<0&&divisor<0))
            {
                dividend=dividend-divisor;
                if((dividend<0&&divisor<0))
                {
                    toProceed=dividend<=divisor && dividend!=0;
                    count++;
                }
                else
                    toProceed=dividend>=divisor && dividend!=0;

                if(temp>=divisor)
                    count++;
            }
            else
            {
                if(toProceed && Math.abs(temp)>=Math.abs(divisor))
                    count--;
                dividend=dividend+divisor;
                if(temp>0)
                    toProceed=Math.abs(dividend)>=Math.abs(divisor) && dividend!=0;
                else
                    toProceed=Math.abs(dividend)<=Math.abs(divisor) && dividend!=0;

            }

        }
        return count;
    }
}
