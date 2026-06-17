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
        int k=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]!=Integer.MIN_VALUE){
                arr[k]=arr[i];
                arr[i]=Integer.MIN_VALUE;
                k++;
            }
            i++;
        }
        for(int j=0;j<arr.length;j++){
            System.out.println(arr[j]);
        }
    }
    public static void main(String []args){
        int []arr={1,1,1,2,2};
        Day2 kaif=new Day2();
        kaif.removeDuplicate(arr);
    }
}
