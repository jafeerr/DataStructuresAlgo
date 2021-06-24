package io.jafeer.recursion;

public class PowerOf2 {
    public static void main(String[] args)
    {
        powerOf2(50);
    }
    public static int powerOf2(int n)
    {
        if(n<1)
            return 0;
        else if(n==1)
        {
            System.out.println(1);
            return 1;
        }
        else
        {
            System.out.println("Looping:"+n);
            int prev=powerOf2(n/2);
            int curr=prev*2;
            System.out.println(curr);
            return curr;
        }

    }
}
