package Professional_friends;

import java.util.HashSet;
import java.util.Scanner;

public class Day10 {
    public boolean containsDupticates(int []nums){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public int [] productExceptSelf(int []nums){
        int []result=new int[nums.length];
        int n=nums.length;
        result[0]=1;
        for(int i=1;i<result.length;i++){
            result[i]=nums[i-1]*result[i-1];
        }
        int right=1;
        for(int i=n-1 ; i>=0;i-- ){
            result[i]*=right;
            right*=nums[i];
        }
        return result;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []nums=new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        Day10 d=new Day10();
//        System.out.println(d.containsDupticates(nums));

        int [] result=d.productExceptSelf(nums);
        for(int i=0;i< result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
