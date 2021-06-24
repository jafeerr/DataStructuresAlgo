package io.jafeer.string;

import java.util.*;

public class Misc {
    public static void main(String[] args) {
        /*
        String[] input={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        for(String result:subdomainVisits(input))
            System.out.println(result);

*/
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        int[] array = {2,-4,-5,-2,-3,-5,0,4,-2};
       for(List<Integer> list:fourSum(array,-14))
       {
           System.out.println();
           for(int no:list)
               System.out.print(no+"\t");
       };
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : cpdomains) {

            String[] splitStr = str.split(" ");
            String[] input = splitStr[1].split("\\.");
            String result = "";
            for (int i = input.length - 1; i >= 0; i--) {
                result = input[i] + result;
                if (map.containsKey(result)) {
                    int count = map.get(result).intValue();
                    map.remove(result);
                    map.put(result, count + Integer.parseInt(splitStr[0]));
                } else {
                    map.put(result, Integer.parseInt(splitStr[0]));
                }
                result = "." + result;
            }


        }
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }

    public static int numDupDigitsAtMostN(int N) {
        int count = 0, start = 10, end = (2 * start) - 1;
        int multiplier = 9;
        while (end <= N && start < end) {
            int temp = 0;
            for (int i = start; i <= end; i++) {
                int no = i;
                int[] digits = new int[10];
                while (no > 0) {
                    int d = no % 10;
                    no = no / 10;
                    if (digits[d] > 0) {
                        //System.out.println(i);
                        temp++;
                        break;
                    } else
                        digits[d] = 1;
                }

            }
            start = start * 10;
            end = (2 * start) - 1;

            if (end > N) {
                start = (N / (start / 10)) * (start / 10);
                end = start + (N % (start / 10));
                count = temp * (start);
                multiplier = ((start / 10) - 1);
            } else {

                count = temp * multiplier;
                multiplier = 9;
            }

        }
        return count;
    }

    public static int findMissingNo(int[] array) {
        int sum = 0, no = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum ^ Math.abs(array[i]);

            if (sum != 0)
                no = sum;
        }
        return no;
    }


    public static void doIT(int n, int j) {


        if (j >= n)
            return;
        if (n - j > 0 && n - j >= j)
            System.out.println(j + " " + (n - j));
        doIT(n, j + 1);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int index1 = 0; index1 < nums.length; index1++) {
            for (int index2 = index1 + 1; index2 < nums.length; index2++) {
                for (int index3 = index2 + 1; index3 < nums.length; index3++) {
                    for (int index4 = index3 + 1; index4 < nums.length; index4++) {
                        int sum = nums[index1] + nums[index2] + nums[index3] + nums[index4];
                        if (sum == target) {
                            List<Integer> nos = new ArrayList<Integer>();
                            nos.add(nums[index1]);
                            nos.add(nums[index2]);
                            nos.add(nums[index3]);
                            nos.add(nums[index4]);
                            if(!contains(list,nos))
                                Collections.sort(nos);
                                list.add(nos);
                        }
                    }
                }
            }
        }
        return list;
    }
    public static boolean contains(List<List<Integer>> list,List<Integer> nos)
    {
        for(List<Integer> listNo:list)
        {
            if(listNo.equals(nos))
                return true;
        }
        return false;
    }
}
