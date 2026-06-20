package Professional_friends;

public class Day6 {
    public static int consecutiveOnes(int []arr){
        int maxCount=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
                maxCount=Math.max(maxCount,count);
            }else{
                count=0;
            }
        }
        return maxCount;
    }

    public static int findSingle(int []arr){
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        return xor;
    }

    public static int subArrayTarget(int []arr,int target){
        int maxWindow=0;
        for(int i=0;i<arr.length;i++){
            int sum=arr[i];
            if(sum==target) {
                maxWindow=Math.max(maxWindow,1);
            }
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                if(sum==target) {
                    int currWindow=j-i+1;
                    maxWindow=Math.max(maxWindow,currWindow);
                }
            }
        }
        return maxWindow;
    }
    public static void main(String[] args){
//        int []arr={1,1,0,1,1,1};
//        System.out.println(consecutiveOnes(arr));
        int []arr2={4,1,2,1,2};
//        System.out.println(findSingle(arr2));
        int []arr={-3, 2, 1};
        System.out.println(subArrayTarget(arr,6));
    }
}
