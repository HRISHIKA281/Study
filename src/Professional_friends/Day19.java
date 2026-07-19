package Professional_friends;
import java.util.*;

public class Day19 {
    public static int numberAnagram(String str,String pat){
        HashMap<Character,Integer> freq=new HashMap<>();
        for(char c:pat.toCharArray()) freq.put(c,freq.getOrDefault(c,0)+1);
        int windowLength=pat.length();
        int left=0;
        int right=0;
        int count=freq.size();
        int ans=0;
        while(right<str.length()){
            char curr=str.charAt(right);
            if(freq.containsKey(curr)){
                freq.put(curr,freq.get(curr)-1);

                if(freq.get(curr)==0) {
                    count--;
                }
            }
            if(right-left+1 == windowLength){
                if(count ==0 ) ans++;

                char out=str.charAt(left);
                if(freq.containsKey(out)){
                    if(freq.get(out)==0){
                        count++;
                    }
                    freq.put(out,freq.get(out)+1);
                }
                left++;
            }
            right++;
        }
        return ans;
    }

    public static int minSubarraySum(int []arr,int target){
        int n=arr.length;
        int sum=0;
        int minLenWin=n;
        int left=0;
        int right=0;

        while(right<n){
            sum+=arr[right];
            while(sum>=target){
                minLenWin=Math.min(minLenWin,right-left+1);
                sum-=arr[left++];
            }
            right++;
        }
        return minLenWin;
    }

    public static List<Integer> maxInWindow(int []arr,int k){
        //this is a monotonic decreasing queue using deque
        Deque<Integer> dq=new LinkedList<>();
        int n=arr.length;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n-k;i++){
            // k se small hua window length se small(out of window)
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }

            //back k ele smaller than arr[i]
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();
            }

            // now after refinement add the current index
            dq.addLast(i);

            //pust in the result the max for the curr window
            if(i>k-1){
                result.add(arr[dq.peekFirst()]);
            }
        }
        return result;
    }
    public static void main(String[]args){
        String str="forxxorfxdofr";
        String pattern="fox";


    }
}
