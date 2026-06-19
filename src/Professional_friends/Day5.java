package Professional_friends;

public class Day5 {
    public static int findMissing(int []arr){
        int n=arr.length;
        int xor1=0;
        int xor2=0;
        for(int i=0;i<n;i++){
            xor1^=arr[i];
        }
        for(int i=1;i<=n+1;i++){
            xor2^=i;
        }
        return xor2^xor1;
    }
    public static void main(String[]args){
        int []arr={8, 2, 4, 5, 3, 7, 1};
        System.out.println(findMissing(arr));
    }

}
