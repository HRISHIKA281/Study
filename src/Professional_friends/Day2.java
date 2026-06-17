package Professional_friends;

public class Day2 {
    public void removeDuplicate(int []arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                arr[i]=Integer.MIN_VALUE;
            }
        }
        if(arr.length>=2 && arr[arr.length-2]==arr[arr.length-1]){
            arr[arr.length-2]=Integer.MIN_VALUE;
        }
//        int k=0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]!=Integer.MIN_VALUE){
//                arr[k]=arr[i];
//                k++;
//            }
//        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String []args){
        int []arr={1,1,1,2,2};
        Day2 kaif=new Day2();
        kaif.removeDuplicate(arr);
    }
}
