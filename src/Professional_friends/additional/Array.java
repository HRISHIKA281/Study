package Professional_friends.additional;

public class Array {
    public static int  removeDuplicatesSorted(int []arr){
        int j=0;
        int i=0;
        while(j<arr.length){
            if(arr[i] != arr[j]){
                i++;
                arr[i]=arr[j];
            }
            j++;
        }
        return i;
    }
    public static void main(String[]args){
        int []arr={1,2,2,3,6,7,7,8,8};
        int uniqueIdx=removeDuplicatesSorted(arr);
        for(int i=0;i<=uniqueIdx;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
