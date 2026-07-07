package Professional_friends;
import java.util.*;

public class Day9 {
    public int [] TwoSum(int []arr,int target){
        int []result=new int [2];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement =target-arr[i];
            if(map.containsKey(complement)){
                result[0]=map.get(complement);
                result[1]=i;
                return result;
            }else{
                map.put(arr[i],i);
            }
        }
        return result;
    }

    public int maxProfit(int []prices){
        int maxProfit=0;
        int currMin=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<currMin){
                currMin=prices[i];
            }else{
                maxProfit=Math.max(maxProfit,prices[i]-currMin);
            }
        }
        return maxProfit;
    }

    public int[] mergeArray(int []arr1,int m,int []arr2,int n){
        int i=m-1;
        int j=n-1;
        int k=m+m-1;
        while(i>=0 && j>=0){
            if(arr1[i]>arr2[j]){
                arr1[k]=arr1[i];
                k--;i--;
            }else{
                arr1[k]=arr2[j];
                k--;j--;
            }
        }
        while(j>=0){
            arr1[k]=arr2[j];
            k--;j--;
        }
        return arr1;
    }
    public static void main(String []args){
        int []arr={1,3,2,6,9};
        Day9 d =new Day9();
        int []result=d.TwoSum(arr,16);
        System.out.println(result[0]+","+result[1]);

        int []arr1={7,6,4,3,1};
        System.out.println(d.maxProfit(arr1));

        int []a={1,2,3,0,0,0};
        int []b={2,5,6};

        d.mergeArray(a,3,b,3);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
