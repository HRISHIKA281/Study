package Professional_friends;
import java.util.*;

public class Day4 {
    public void subString(List<String>result,String curr,String str,int idx){
        if(idx==str.length()){
            result.add(curr);
            return;
        }
        String c=String.valueOf(str.charAt(idx));
        subString(result,curr+c,str,idx+1);
        subString(result,curr,str,idx+1);
    }

    public void subArraySum(List<Integer>sum , int initial,int []arr,int idx){
        if(idx==arr.length){
            sum.add(initial);
            return;
        }
        subArraySum(sum,initial+arr[idx],arr,idx+1);
        subArraySum(sum,initial,arr,idx+1);
    }

    public void generateParanthesis(List<String> result,String curr,int n,int l,int r){
        if(l==n && r == n){
            result.add(curr);
            return;
        }
        if(l<n){
            generateParanthesis(result,curr+"(",n,l+1,r);
        }
        if(r<l){
            generateParanthesis(result,curr+")",n,l,r+1);
        }
    }
    public static void main(String []args){
        String str="abc";
        List<String> result=new ArrayList<>();
        Day4 d=new Day4();
        d.subString(result,"",str,0);
//        System.out.println(result);
        int []arr={1,2,3};
        List<Integer> sum=new ArrayList<>();
        d.subArraySum(sum,0,arr,0);
//        System.out.println(sum);
        int n=3;
        List<String> list=new ArrayList<>();
        d.generateParanthesis(list,"",n,0,0);
        System.out.println(list);
    }
}
