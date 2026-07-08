package Professional_friends;
import java.util.*;

public class Day11 {
    public void moveAllZero(int []arr){
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]!=0){
                arr[i]=arr[j];
                i++;
            }
            j++;
        }
        while(i<arr.length){
            arr[i]=0;
            i++;
        }
    }

    public void dutchFlag(int []arr){
        int j=0;
        int low=0;
        int high=arr.length-1;
        while(j<=high){
            if(arr[j]==0){
                int temp=arr[j];
                arr[j]=arr[low];
                arr[low]=temp;
                low++;j++;
            }else if(arr[j]==2){
                int temp=arr[j];
                arr[j]=arr[high];
                arr[high]=temp;
                high--;
            }else{
                j++;
            }
        }
    }

    public int greaterThanPrev(int []arr){
        int maxSeen=arr[0];
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(maxSeen<arr[i]){
                maxSeen=arr[i];
                count++;
            }
        }
        return count;
    }

    public int findOddOccurance(int []arr){
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(mid%2 != 0) mid--;
            if(arr[mid]==arr[mid+1]) {
                low=mid+2; // the odd one is to the right
            }else{
                high=mid; // the odd one is at or before mid
            }
        }
        return arr[low];
    }

    public int secondLargest(int []arr){
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i]){
                secondLargest=largest;
                largest=arr[i];
            }else if(secondLargest<arr[i]){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }
    public int findMissing(int []arr,int n){
        //n is the size of array
        int originalSum=n*(n+1)/2;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return originalSum-sum;
    }
    public void reverse(int []arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;i++;
        }
    }

    public void reverse(int []arr,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;i++;
        }
    }
    public void rotate(int []arr,int k){
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr);
    }

    public int[] twoSum(int []arr,int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement=target-arr[i];
            if(map.containsKey(complement)){
                return new int[]{complement,arr[i]};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String []args){
//        Q 1 Move All Zeros to the Endarr = [4,5,0,1,9,0,5,0] → output = [4,5,1,9,5,0,0,0]
        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int []arr=new int[n];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=sc.nextInt();
//        }
        Day11 d=new Day11();
//        d.moveAllZero(arr);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();

//        Q2 Sort an Array of 0s, 1s, and 2s (Dutch National Flag)
//        int []nums={1,0,2,1,1,0,2,1};
//        d.dutchFlag(nums);
//        for(int i=0;i<nums.length;i++){
//            System.out.print(nums[i]+" ");
//        }
//        Q3 Count Elements Greater Than All Previous Elements
        int []arr = {5, 72, 2, 8, 9, 1,99};
        System.out.println(d.greaterThanPrev(arr));

//        Q4 Find the Odd-Occurring Element in O(log n)
        int []arr1={1,0,2,1,3,0,2,3,1};
        Arrays.sort(arr1);

    }
}
