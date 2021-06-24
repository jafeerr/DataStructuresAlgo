package io.jafeer.recursion;

public class TowerOfHonoi {
    public static void main(String[] args)
    {
        /*String[] disks={"1","2"};
        final String[] Tower={"A","B","C"};

        for(int i=0;i<Math.pow(2,disks.length);i++)
        {

        }*/
        towerOfHanoi(3, 'A', 'C', 'B',"main");
    }
    static void towerOfHanoi(int n, char from_rod, char to_rod, char inter,String calledFrom)
    {
        if (n == 1)
        {
            System.out.println("print 1\t"+"Move disk 1 from rod " +  from_rod + " to rod " + to_rod + "\t"+calledFrom);
            return;
        }
        towerOfHanoi(n-1, from_rod, inter, to_rod,"1st");
        towerOfHanoi(n-1, inter, to_rod, from_rod,"2nd");
    }
}
