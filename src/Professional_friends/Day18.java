package Professional_friends;

import java.util.PriorityQueue;

public class Day18 {
    public static int countMinCost(int []arr){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int num1=pq.remove();
            int num2=pq.remove();
            int sum=num1+num2;
            cost+=sum;
            pq.add(sum);
        }
        return cost;
    }
    public static void main(String []args){
        int []arr={2,5,4,8,6,9};
        System.out.println(countMinCost(arr));
    }
}
