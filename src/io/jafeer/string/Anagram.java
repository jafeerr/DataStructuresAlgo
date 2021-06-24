package io.jafeer.string;

public class Anagram {
    public static void main(String[] args)
    {
        String input="CA";
        int totalCombinations=(int)Math.pow(input.length(),input.length());


        for(int i=0;i<totalCombinations;i++)
        {
            String result="";
            for(int j=0;j<input.length();j++)
            {
                int temp =(int)(totalCombinations/(Math.pow(input.length(),j+1)));
                //System.out.println((Math.pow(input.length(),j+1))+".."+temp);
                int index=(i/temp)%(input.length());
                if(!result.contains(( ""+input.charAt(index))))
                result=result+input.charAt(index);
                else
                    break;
            }
            if(result.length()==input.length())
            System.out.println(result);
        }
    }
}
